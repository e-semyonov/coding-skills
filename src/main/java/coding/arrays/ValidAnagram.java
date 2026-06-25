package coding.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    // solution 1: deconstruct String to array and use hashMap to count each letter number of occurrences
    public boolean isAnagram(String s, String t) {

        char[] charArrays = s.toCharArray();
        char[] charArrayt = t.toCharArray();

        if (charArrays.length != charArrayt.length) {
            return false;
        }

        HashMap<Character, Integer> charCountMapS = new HashMap<Character, Integer>();
        for (char c : charArrays) {
            charCountMapS.put(c, charCountMapS.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> charCountMapT = new HashMap<Character, Integer>();
        for (char c : charArrayt) {
            charCountMapT.put(c, charCountMapT.getOrDefault(c, 0) + 1);
        }

        if (charCountMapS.size() != charCountMapT.size()) {
            return false;
        }

        return compare1(charCountMapS, charCountMapT);
        // or
//        return charCountMapS.equals(charCountMapT);

    }

    public boolean compare1(HashMap<Character, Integer> charCountMapS, HashMap<Character, Integer> charCountMapT) {

        //compare the maps
        for (Map.Entry<Character, Integer> entry : charCountMapS.entrySet()) {

            Character key = entry.getKey();
            Integer value = entry.getValue();
            Integer remove = charCountMapT.remove(key);
            if (remove == null) return false; // character from s not found in t
            if (!remove.equals(value)) return false; // character count does not match
        }

        return charCountMapT.isEmpty();


    }

    // solution 2: using hashtable to count the number of occurrences of each character.
    // utilizing a simple array of int
    public boolean isAnagram2(String s, String t) {

        int[] hashTable = new int[26];// capacity is the size of the alphabet

        for (int i = 0; i < s.length(); i++) {
            hashTable[s.charAt(i) - 'a']++;
            hashTable[t.charAt(i) - 'a']--;
        }

        return Arrays.stream(hashTable).filter(i -> i != 0).sum() == 0;


    }

    public static void main(String[] args) {

        ValidAnagram validAnagram = new ValidAnagram();
        String s = "anagram";
        String t = "nagaram";
        System.out.println(validAnagram.isAnagram2(s, t)); // true

        s = "anagram";
        t = "nanaram";
        System.out.println(validAnagram.isAnagram(s, t)); // false
    }

}
