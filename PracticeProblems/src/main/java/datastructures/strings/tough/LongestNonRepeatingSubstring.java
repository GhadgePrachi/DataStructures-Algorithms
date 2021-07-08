package datastructures.strings.tough;

import java.util.HashMap;

public class LongestNonRepeatingSubstring {
    public static String longestSubstringWithoutDuplication(String str) {
        int[] longest = new int[] {0, 0};
        int startIndex = 0, endIndex = 0;
        HashMap<Character, Integer> lastSeen = new HashMap<>();
        while (endIndex < str.length()) {
            char currentCharacter = str.charAt(endIndex);
            if (lastSeen.containsKey(currentCharacter)) {
                startIndex = Math.max(lastSeen.get(currentCharacter) + 1, startIndex);
            }
            if (longest[1] - longest[0] < endIndex - startIndex) {
                longest = new int[] {startIndex, endIndex};
            }
            lastSeen.put(currentCharacter,endIndex);
            endIndex++;
        }
        return str.substring(longest[0], longest[1] + 1);
    }
}
