package datastructures.strings.tough;

import java.util.HashMap;
import java.util.Map;

public class SmallestSubstring {
    public static String smallestSubstringContaining(String bigString, String smallString) {
        Map<Character, Integer> targetCharCounts = getCharCounts(smallString);
        int startIndex = 0, endIndex = 0, uniqueCount = targetCharCounts.size();;
        int minLengthStartIndex = 0, minLength = Integer.MAX_VALUE;

        while(endIndex < bigString.length()) {
            char currentCharacter = bigString.charAt(endIndex);
            targetCharCounts.put(currentCharacter, targetCharCounts.getOrDefault(currentCharacter,0) - 1);
            if (targetCharCounts.get(currentCharacter) == 0) {
                uniqueCount--;
            }
            if (uniqueCount == 0) {
                while (startIndex <= endIndex && uniqueCount == 0) {
                    if (minLength > endIndex - startIndex + 1) {
                        minLength = endIndex - startIndex + 1;
                        minLengthStartIndex = startIndex;
                    }
                    char startCharacter = bigString.charAt(startIndex);
                    if (targetCharCounts.get(startCharacter) == 0) {
                        uniqueCount++;
                    }
                    targetCharCounts.put(startCharacter, targetCharCounts.get(startCharacter) + 1);
                    startIndex++;
                }
            }
            endIndex++;
        }

        if (minLength != Integer.MAX_VALUE) {
            return bigString.substring(minLengthStartIndex, minLengthStartIndex + minLength);
        } else {
            return "";
        }
    }

    public static Map<Character, Integer> getCharCounts(String string) {
        Map<Character, Integer> targetCharCounts = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            char current = string.charAt(i);
            targetCharCounts.put(current, targetCharCounts.getOrDefault(current,0) + 1);
        }
        return targetCharCounts;
    }
}
