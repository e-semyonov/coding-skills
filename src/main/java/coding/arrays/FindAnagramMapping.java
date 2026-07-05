package coding.arrays;

import java.util.HashMap;

class FindAnagramMapping {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> indexMap1 = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            indexMap1.put(nums2[i], i);
        }
        int[] aMap = new int[nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            int indexOfItem = indexMap1.get(nums1[i]);
            aMap[i] = indexOfItem;
        }

        return aMap;
    }
}
