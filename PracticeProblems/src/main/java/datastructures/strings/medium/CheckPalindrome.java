package datastructures.strings.medium;

import java.util.HashMap;

public class CheckPalindrome {
    /**Check if Palindrome**/
    public static boolean isPalindrome(String str) {
        int left = 0;
        while(left < str.length()/2){
            int right = str.length() - 1 - left;
            if (str.charAt(left) != str.charAt(right))
                return false;
            left++;
        }
        return true;
    }

    /**Check if deleting K Characters can form Palindrome**/
    public boolean validPalindrome(String s) {
        HashMap<String, Boolean> map = new HashMap<>();
        return validPalindrome(s, 0, s.length() - 1, 1, map);
    }

    public boolean validPalindrome(String s, int startIndex, int endIndex, int k, HashMap<String, Boolean> map) {
        String key = String.valueOf(startIndex) + ":" + String.valueOf(endIndex) + ":" + String.valueOf(k);
        if (map.containsKey(key)) {
            return map.get(key);
        }

        if (k < 0) {
            return false;
        }

        if (startIndex >= endIndex) {
            return true;
        }

        boolean result;
        if (s.charAt(startIndex) == s.charAt(endIndex)) {
            result = validPalindrome(s, startIndex + 1, endIndex - 1, k, map);
        } else {
            result = validPalindrome(s, startIndex + 1, endIndex, k - 1, map) ||
                    validPalindrome(s, startIndex, endIndex - 1, k - 1, map);
        }
        map.put(key, result);
        return result;
    }

    /**Check if String Permutation can form Palindrome**/
    public static boolean isPermutationOfPalindromeUsingDynamicStorage(String str) {
        if (str == null) return false;
        int[] table = buildFrequencyTable(str.toCharArray());
        return checkHasOnlyOneOddCountCharacter(table);
    }

    private static int[] buildFrequencyTable(char[] array){
        int[] letters = new int[128];
        for (char currentCharacter : array) {
            letters[currentCharacter]++;
        }
        return letters;
    }

    private static  boolean checkHasOnlyOneOddCountCharacter(int[] table){
        boolean foundOdd = false;
        for (int i = 0;i<table.length;i++) {
            if (table[i] % 2 == 1) {
                if(foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    public static boolean isPermutationOfPalindromeUsingStaticStorage(String str) {
        int[] letters = new int[128];
        char[] array = str.toCharArray();
        int oddCount = 0;
        for (char currentCharacter : array) {
            letters[currentCharacter]++;
            if (letters[currentCharacter] % 2 == 1) {
                oddCount++;
            } else {
                oddCount--;
            }
        }
        return oddCount <= 1;
    }

    public static boolean isPermutationOfPalindromeUsingBitVector(String str) {
        int bitVector = createBitVector(str.toCharArray());
        return checkHasOnlyOneBitSet(bitVector);
    }

    private static int createBitVector(char[] array){
        int bitVector = 0;
        for (char currentCharacter : array) {
            bitVector = toggle(bitVector,currentCharacter);
        }
        return bitVector;
    }

    private static int toggle(int bitVector, char currentCharacter){
        int value = currentCharacter - 'a';
        if ((bitVector & (1 << value)) == 1) {
            bitVector = bitVector & ~(1 << value);
        } else {
            bitVector = bitVector | (1<<value);
        }
        return bitVector;
    }

    private static boolean checkHasOnlyOneBitSet(int bitVector){
        return ((bitVector & ( bitVector - 1)) == 0);
    }

    /**Get Longest Palindromic Substring**/
    public static String longestPalindromicSubstring(String str) {
        for (int length = str.length(); length > 0; length--){
            for (int startIndex = 0; startIndex <= str.length() - length; startIndex++){
                int endIndex = startIndex + length;
                if (isPalindrome(str.substring(startIndex, endIndex))){
                    return str.substring(startIndex, endIndex);
                }
            }
        }
        return "";
    }

    public static String longestPalindromicSubstringExpandAtCenter(String str) {
        int[] longest = new int[]{0, 0};
        for(int i = 1; i < str.length(); i++){
            int[] odd = getLongestPalindrome(str,i-1,i+1);
            int[] even = getLongestPalindrome(str,i-1,i);
            int[] currentLongest = odd[1] - odd[0] > even[1] - even[0] ? odd : even;
            longest = currentLongest[1] - currentLongest[0] > longest[1] - longest[0] ? currentLongest : longest;
        }
        return str.substring(longest[0],longest[1]+1);
    }

    public static int[] getLongestPalindrome(String str, int startIndex, int endIndex){
        while (startIndex >= 0 && endIndex < str.length()){
            if (str.charAt(startIndex) != str.charAt(endIndex)) {
                break;
            }
            startIndex--;
            endIndex++;
        }
        return new int[] {startIndex + 1,endIndex - 1};
    }
}
