package coding;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class JobService {

    private static final int CORE_THREADS = 10;
    private static final int MAX_THREADS = 10;
    private static final int QUEUE_CAPACITY = 100;

    private static final String DB_URL = System.getenv("DB_URL");
    private static final String DB_USER = System.getenv("DB_USER");
    private static final String DB_PASSWORD = System.getenv("DB_PASSWORD");

    private static final String SELECT_PENDING_JOBS_SQL = """
            SELECT id, name
            FROM jobs
            WHERE status = ?
            ORDER BY id ASC
            """;

    private final ExecutorService executorService;

    public JobService() {
        this.executorService = new ThreadPoolExecutor(
                CORE_THREADS,
                MAX_THREADS,
                0L,
                TimeUnit.MILLISECONDS,
                new PriorityBlockingQueue<>(QUEUE_CAPACITY)
        );
    }

    public void processJobs() {
        List<Job> jobs = fetchJobsFromDb();

        for (Job job : jobs) {
            executorService.execute(new JobTask(job));
        }

        shutdownExecutor();
    }

    /**
     * DB call that retrieves pending jobs.
     *
     * Expected table shape:
     * jobs(id INT, name VARCHAR, status VARCHAR, result VARCHAR)
     *
     * Required environment variables:
     * DB_URL, DB_USER, DB_PASSWORD
     */
    private List<Job> fetchJobsFromDb() {
        List<Job> jobs = new ArrayList<>();

        if (DB_URL == null || DB_USER == null || DB_PASSWORD == null) {
            throw new IllegalStateException("DB_URL, DB_USER, and DB_PASSWORD environment variables must be set");
        }

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(SELECT_PENDING_JOBS_SQL)) {

            statement.setString(1, "PENDING");

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    jobs.add(new Job(id, name));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve jobs from database", e);
        }

        return jobs;
    }

    private void processJob(Job job) {
        try {
            System.out.println(Thread.currentThread().getName() + " processing " + job.getName());
            Thread.sleep(300); // simulate work

            String result = "Result for " + job.getName();
            job.setResult(result);

            System.out.println(Thread.currentThread().getName() + " finished " + job.getName());
            updateJobResultInDb(job);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            job.setResult("Interrupted");
            updateJobResultInDb(job);
            System.err.println("Job interrupted: " + job.getName());
        }
    }

    /**
     * Mock DB update.
     * In a real application, this would update the job row with the processing result.
     */
    private void updateJobResultInDb(Job job) {
        System.out.println("Updated DB for " + job.getName() + " with result: " + job.getResult());
    }

    private void shutdownExecutor() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        JobService jobService = new JobService();
        jobService.processJobs();
    }

    private static class Job {
        private final int id;
        private final String name;
        private String result;

        private Job(int id, String name) {
            this.id = id;
            this.name = name;
        }

        private int getId() {
            return id;
        }

        private String getName() {
            return name;
        }

        private String getResult() {
            return result;
        }

        private void setResult(String result) {
            this.result = result;
        }
    }

    private class JobTask implements Runnable, Comparable<JobTask> {
        private final Job job;

        private JobTask(Job job) {
            this.job = job;
        }

        @Override
        public void run() {
            processJob(job);
        }

        @Override
        public int compareTo(JobTask other) {
            return Integer.compare(this.job.getId(), other.job.getId());
        }
    }
}
