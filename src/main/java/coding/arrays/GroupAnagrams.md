### Group Anagrams
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:
Input: strs = [""]
Output: [[""]]

Example 3:
Input: strs = ["a"]
Output: [["a"]]


### Sorting
#### Intuition
Anagrams become identical when their characters are sorted.
For example, "eat", "tea", and "ate" all become "aet" after sorting.
By using the sorted version of each string as a key, we can group all anagrams together.
Strings that share the same sorted form must be anagrams, so placing them in the same group is both natural and efficient.
#### Algorithm
1. Create a hash map where each key is the sorted version of a string, and the value is a list of strings belonging to that anagram group.
2. Iterate through each string in the input list:
    Sort the characters of the string to form a key.
    Append the original string to the list corresponding to this key.
3. After processing all strings, return all values from the hash map, which represent the grouped anagrams.
```Text 
Time & Space Complexity
    Time complexity: O(m∗nlog⁡n)O(m∗nlogn)
    Space complexity: O(m∗n)O(m∗n)
 ```
