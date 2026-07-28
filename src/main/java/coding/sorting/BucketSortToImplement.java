package coding.sorting;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Bucket sort is a distribution-based sorting algorithm that works by partitioning an array into several smaller groups called buckets.
 * Each bucket is sorted individually using a separate sorting algorithm (often Insertion Sort) or by recursively applying bucket sort.
 * Finally, the sorted buckets are concatenated to form the complete sorted array.
 * This algorithm achieves high efficiency—often running in linear time—when the input data is uniformly distributed over a known range.
 *
 * Scatter: Create an array of empty buckets. Loop through the original data and place each element into its corresponding bucket
 * based on a specific mapping formula.
 * Sort: Iterate through the buckets and sort the contents of each non-empty bucket using a stable sort, like insertion sort.
 * Gather: Visit the buckets sequentially from first to last and copy the sorted elements back into the original array.
 *
 * When to Use (and When Not To)
 * Ideal Use Cases:
 * Sorting data that is tightly bounded and uniformly spread over a range
 * (e.g., grading percentages, floating-point probability values between 0 and 1).
 * When linear runtime performance is critical and extra memory overhead is acceptable.
 * Drawbacks:High memory consumption since you must allocate extra collections for buckets.
 * Degrades significantly if data contains severe clustering or out-of-distribution outliers, as elements accumulate into few buckets.
 */

public class BucketSortToImplement {

    BucketSortToImplement() {

    }

    public List<Integer> process(List<Integer> input) {
        List<Integer> result = new ArrayList<>();

        // bucket logic

        // create buckets, frequency map of the integers in the input
        Map<Integer, Integer> buckets = new HashMap<>();
        for(Integer i : input){
            buckets.compute(i, (k, v) -> v == null ? 1 : buckets.get(k) + 1);
        }// map will need to be sorted

        // go over each bucket and sort



        return result;

    }


    public static void main(){
        BucketSortToImplement bucketSort = new BucketSortToImplement();
        List<Integer> integers = List.of(1, 2, 4, 5, 7, 9, 3);
        List<Integer> sortedIntegers = bucketSort.process(integers);
        System.out.println("Sorted array = " + sortedIntegers);
    }
}
