package coding.arrays;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    /**
     * Recommended Time & Space Complexity
     * <p>
     * You should aim for a solution with O(m * n) time and O(m) space, where m is the number of strings and n is the length of the longest string.
     */
    class Solution {

        public List<List<String>> groupAnagrams(String[] strs) {


            return groupAnagram2(strs);
        }


        // 1 using sorting to use equals on strings.

        /**
         * A naive solution would be to sort each string and group them using a hash map.
         * This would be an O(m * nlogn) solution.
         * Though this solution is acceptable, can you think of a better way without sorting the strings?
         *
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


        // solution 2
        // By the definition of an anagram, we only care about the frequency of each character in a string. How is this helpful in solving the problem?
        // algorithm:
        // 1. iterate over the strs
        // 2. for each string, create a frequency array of size 26 (for each letter in the alphabet)
        // 3. use the frequency array as a key in a hash map to group the anagrams together
        public List<List<String>> groupAnagram2(String[] strs) {
            HashMap<String, List<String>> frequencyMap = new HashMap<String, List<String>>();

            int[] frequencyArray = new int[26];
            for (String str : strs) {
                char[] arr = str.toCharArray();
                Arrays.fill(frequencyArray, 0); // redundant
                for (char c : arr) {
                    frequencyArray[c - 'a'] = frequencyArray[c - 'a'] + 1;
                }

                String key = Arrays.toString(frequencyArray);// for example: [1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
                frequencyMap.putIfAbsent(key, new ArrayList<String>());
                frequencyMap.get(key).add(str);
            }
            return new ArrayList(frequencyMap.values());
        }
    }


    public static void main(String[] args) {

        GroupAnagrams groupAnagrams = new GroupAnagrams();
        Solution solution = groupAnagrams.new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = solution.groupAnagram1(strs);
        System.out.println("Anagram1 result" + result);
        result = solution.groupAnagram2(strs);
        System.out.println("Anagram2 result" + result);

    }


}
