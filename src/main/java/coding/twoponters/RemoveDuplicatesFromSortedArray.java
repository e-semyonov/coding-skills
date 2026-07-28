package coding.twoponters;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int i = 0;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }


    // write main with tests
    public static void main(String... args){
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        int[] array = new int[]{1,2,4,5,5,10};
        int removedDuplicates = removeDuplicatesFromSortedArray.removeDuplicates(array);
        System.out.println("Removed duplicates unique integers are : " + removedDuplicates + " "+ "and the array is now: ");
        for(int i = 0; i < removedDuplicates; i++){
            System.out.print(array[i] + " ");
        }

    }
}
