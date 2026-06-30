package coding.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ArrayInitialization {


    public static void main(String[] args) {


        // primitive type array
        // to initialize use: 'type' '[]' 'name' = new 'type'['size'] or {'values separated by comma'}
        // 1
        int[] hashTable = new int[26]; // defaults to 0
        // 2
        char[] chars = {'a', 'b', 'c'};
        // 3
        int[] nums = {1, 2, 3, 4, 5};
        // 4 - type reference array
        Integer[] newNumArr = new Integer[]{1, 2, 3};
        Character[] newCharArr = new Character[]{'a', 'b', 'c'};

        //List.of(...) returns an immutable list.
        //Arrays.asList(...) returns a fixed-size list backed by the array.
        // convert array to list
        // wrong way of converting array to a list
        List<int[]> list = Arrays.asList(nums);// list of the array as the element, means alist of 1 element type that is int[]
        List<int[]> list1 = List.of(nums);// same affect

        // initialize List
        // 1 - immutable list    integerList.add(4); // UnsupportedOperationException
        List<Integer> integerList = List.of(1, 2, 3);
        // 2 - mutable list
        ArrayList<Integer> integerArrayList = new ArrayList<>(List.of(1, 2, 3));
        integerArrayList.add(1);
        // 3
        List<Integer> integerList2 = new ArrayList<>();
        integerList2.add(1);
        integerList2.add(2);
        integerList2.add(3);
    }

    /**
     * int[] does not convert directly to List<Integer> with Arrays.asList(...) or List.of(...)
     * use stream boxing or a manual loop
     * reference arrays like Integer[] and Character[] work with Arrays.asList(...) / List.of(...)
     * Explains how to convert an array to a List.
     * 1. Arrays.asList(...)
     * 2. List.of(...)
     * 3. Arrays.stream(...).boxed().toList()
     * 4. IntStream.of(...).boxed().toList()
     * 5. manual loop
     *
     * Examples:
     * - String[] -> List<String>: Arrays.asList(names) or List.of(names)
     * - Integer[] -> List<Integer>: Arrays.asList(numbers) or List.of(numbers)
     * - int[] -> List<Integer>: Arrays.stream(nums).boxed().toList()
     * - int[] -> List<Integer>: IntStream.of(nums).boxed().toList()
     * - int[] -> mutable List<Integer>: use a loop and add each value manually
     */
    public static void explainArrayToListConversion() {

        int[] nums = {1, 2, 3};
        List<Integer> list1 = Arrays.stream(nums)                .boxed().toList(); // unmodifiable list returns error on modification directly or through an iterator
        List<Integer> list2 = java.util.stream.IntStream.of(nums).boxed().toList(); // same here

        List<Integer> mutableList = new ArrayList<>(); // mutable list
        for (int n : nums) {
            mutableList.add(n);
        }

        String[] names = {"A", "B", "C"};
        List<String> nameList1 = Arrays.asList(names); // mutable list
        List<String> nameList2 = List.of(names); // immutable list

        System.out.println(nameList1);
        System.out.println(nameList2);
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(mutableList);
    }


}
