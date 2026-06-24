package coding.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

public class ContainsDuplicate {

    // TODO: NOTE

    /**
     * Note: the difference between int[] and Integer[] is that int[] is a primitive type array, while Integer[] is an
     * object type array. The primitive type array is more efficient in terms of memory and performance, while the
     * object type array is more flexible and can be used with generics and collections.
     * <p>
     * boxed() returns the wrapper type that corresponds to the primitive stream you started from:
     * so for an IntStream (e.g. from an int[]) boxed() gives Stream<integer>. For LongStream it gives Stream<long>, for DoubleStream Stream<double>.
     * Arrays.stream(nums) where nums is int[] returns an IntStream. IntStream.boxed() -> Stream<integer>.</integer>
     * Arrays.stream(longArray) returns LongStream. LongStream.boxed() -> Stream<long>.</long>
     * Arrays.stream(doubleArray) returns DoubleStream. DoubleStream.boxed() -> Stream<double>.</double>
     * There are no primitive streams for byte/short/char/boolean; those must be handled differently (e.g. map to int or manually box).
     * Why it matters
     * boxed() produces wrapper objects (Integer/Long/Double) which allocates objects and has a runtime cost (boxing).
     * After boxed() you get a Stream of reference types and can use normal collectors: .boxed().collect(Collectors.toSet()) yields a Set<integer> for an int[].</integer>
     */
    public void code() {
        int[] nums = {1, 2, 3, 4, 5};
        List<int[]> list = Arrays.asList(nums);// list of the array as the element

        Integer[] newNumArr = new Integer[]{1, 2, 3};
        List<Integer> list1 = Arrays.asList(newNumArr);// list of the array as list of Integers

        // correct way to convert int[] to List<Integer> using Stream API
        // Using Arrays
        List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());
        // Using Streams as IntStream
        IntStream.of(nums).boxed().collect(Collectors.toList());
    }

    public boolean hasDuplicate(int[] nums) {

        HashSet<Integer> set = new HashSet<Integer>();
        boolean hasDuplicates = false;

        // solution 1: using HashSet
        for (int i : nums) {
            set.add(i);
        }
        hasDuplicates = set.size() == nums.length;


        // solution 2: using Arrays and Stream
        Set<Integer> otherSet = Arrays.stream(nums).boxed().collect(toSet());
        return otherSet.size() != nums.length;
    }

    public static void main(String[] args) {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        int[] nums = {1, 2, 3, 4, 5, 1};
        System.out.println(containsDuplicate.hasDuplicate(nums)); // true
    }
}
