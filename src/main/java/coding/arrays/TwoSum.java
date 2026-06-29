package coding.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {



        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> indices = new HashMap<>();  // val -> index

            for (int i = 0; i < nums.length; i++) {
                indices.put(nums[i], i);
            }

            for (int i = 0; i < nums.length; i++) {
                int diff = target - nums[i];
                if (indices.containsKey(diff) && indices.get(diff) != i) {
                    return new int[]{i, indices.get(diff)};
                }
            }

            return new int[0];
        }


    public static void main(String[] args) {

        TwoSum twoSum = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum.twoSum(nums, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]"); // Output: Indices: [0, 1]

        int[] numsEqual = {5,5};
        int ten = 10;
        int[] sum = twoSum.twoSum(numsEqual, ten);


    }
    }

