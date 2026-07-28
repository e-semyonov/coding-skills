package coding.twoponters;

public class TwoIntegerSumInSortedArray {

    // Time complexity: O(n2)
    // Space complexity: O(1)
    public int[] twoSumBruteForce(int[] numbers, int target) {
        int [] result = new int[2];
        // brute force
        int aSize = numbers.length;

        for (int i = 0; i < aSize; i ++) {
            for(int j = i + 1; j < aSize; j++){
                if(numbers[i] + numbers[j] == target) {
                    result[0] = i+1;
                    result[1] = j+1;
                    break;
                }
            }
        }
        return result;
    }




    // Time complexity: O(n)
    //Space complexity: O(1)
    public int[] twoSum(int[] numbers, int target) {
        int [] result = new int[2];
        // brute force
        int aSize = numbers.length;
        int l = 0;
        int r = aSize - 1;

        while(l < r) {

            if (numbers[l] + numbers[r] == target) {
                result[0] = l+1;
                result[1] = r+1;
                break;
            } else if( numbers[l] + numbers[r] > target) {
                r--;

            } else if(numbers[l] + numbers[r] < target) {
                l++;
            }
        }
        return result;
    }

}
