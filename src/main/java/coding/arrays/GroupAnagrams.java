package coding.arrays;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {


    /**
     * Recommended Time & Space Complexity
     *
     * You should aim for a solution with O(m * n) time and O(m) space, where m is the number of strings and n is the length of the longest string.
     */
    class Solution {

        public List<List<String>> groupAnagrams(String[] strs) {


            return groupAnagram1(strs);
        }


        // 1 using sorting to use equals on strings.
        /**
         * A naive solution would be to sort each string and group them using a hash map.
         * This would be an O(m * nlogn) solution.
         * Though this solution is acceptable, can you think of a better way without sorting the strings?
         * @param strs
         * @return
         */
        public List<List<String>> groupAnagram1(String[] strs) {

            HashMap<String, List<String>> sortedStringToList = new HashMap<String, List<String>>();
            for (String str : strs) {

                char[] charArrStr = str.toCharArray();
                Arrays.sort(charArrStr);
                sortedStringToList.putIfAbsent(new String(charArrStr), new ArrayList<>());
                List<String> groupedStrings = sortedStringToList.get(new String(charArrStr));
                groupedStrings.add(str);
            }
            return new ArrayList<>(sortedStringToList.values());
        }
    }

    public static void main(String[] args) {

        GroupAnagrams groupAnagrams = new GroupAnagrams();
        Solution solution = groupAnagrams.new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = solution.groupAnagrams(strs);
        System.out.println(result);
    }

}
