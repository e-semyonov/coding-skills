package coding.twoponters;


/*
Given a string s, return true if it is a palindrome, otherwise return false.

A palindrome is a string that reads the same forward and backward. It is also case-insensitive and ignores all non-alphanumeric characters.

Note: Alphanumeric characters consist of letters (A-Z, a-z) and numbers (0-9).
 */
// https://neetcode.io/problems/is-palindrome/question?list=neetcode150
public class ValidPalindrome {
    // algorithm:
    // 1. Iterate the string a clean whitespace and non-alphanumeric characters
    // 2. Use two pointers, one at the start and one at the end of the string
    // 3. Compare the characters at the two pointers, if they are not equal, return false
    // 4. Move the pointers towards the center of the string

    public boolean validPalindrome(String input){

//        String inputWithoutWhiteSpaces = input.replace(" ", ""); O(n) since removing a char goes over all chars in the input.

        char[] inputArray = input.toCharArray();
        char[] inputArrayCleaned = new char[inputArray.length];
        int j = 0;
        // clean the input
        for (int i = 0; i < inputArray.length; i++){
            if (Character.isLetterOrDigit(inputArray[i])){ // remember that
                inputArrayCleaned[j] = Character.toLowerCase(inputArray[i]);
                j++;
            }
        }
        // check the new clean array with two pointers
        for(int i=0, k=j-1; i < k; i++,k--){
            if(inputArrayCleaned[i] != inputArrayCleaned[k]) {
                return false;
            }
        }
        return true;
    }
    // Better solution
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            char l = Character.toLowerCase(s.charAt(left));
            char r = Character.toLowerCase(s.charAt(right));

            if (!Character.isLetterOrDigit(l)) {
                left++;
            } else if (!Character.isLetterOrDigit(r)) {
                right--;
            } else if (l != r) {
                return false;
            } else {
                left++;
                right--;
            }
        }

        return true;
    }


    // Given a string of characters, return true if it's a palindrome,
    // return false otherwise: O(n)
    public static boolean isPalindromeBest(String word) {
        int L = 0, R = word.length() - 1;
        while (L < R) {
            if (word.charAt(L) != word.charAt(R)) {
                return false;
            }
            L++;
            R--;
        }
        return true;
    }
    public static void main(String [] strings){
        String input = "Was it a car or a cat I saw?";
        ValidPalindrome  validPalindrome = new ValidPalindrome();
        boolean result = validPalindrome.validPalindrome(input);
        System.out.println("Is the input a valid palindrome? " + result);
    }
}
