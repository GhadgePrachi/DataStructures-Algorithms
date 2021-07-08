package datastructures.strings.tough;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OtherStringAnagram {
    public List<Integer> findAnagrams(String bigString, String smallString) {
        int bigLength = bigString.length(), smallLength = smallString.length();
        if (bigLength < smallLength) {
            return new ArrayList<>();
        }

        Map<Character, Integer> smallCharCount = new HashMap<>();
        Map<Character, Integer> bigCharCount = new HashMap<>();
        List<Integer> output = new ArrayList<>();
        for (char currentCharacter : smallString.toCharArray()) {
            smallCharCount.put(currentCharacter, smallCharCount.getOrDefault(currentCharacter, 0) + 1);
        }

        int endIndex = 0;
        while (endIndex < bigLength) {
            char currentCharacter = bigString.charAt(endIndex);
            bigCharCount.put(currentCharacter, bigCharCount.getOrDefault(currentCharacter, 0) + 1);
            if (endIndex >= smallLength) {
                currentCharacter = bigString.charAt(endIndex - smallLength);
                bigCharCount.put(currentCharacter, bigCharCount.get(currentCharacter) - 1);
                if (bigCharCount.get(currentCharacter) == 0) {
                    bigCharCount.remove(currentCharacter);
                }
            }
            if (smallCharCount.equals(bigCharCount)) {
                output.add(endIndex - smallLength + 1);
            }
            endIndex++;
        }
        return output;
    }

    public List<Integer> findAnagramsOptimal(String bigString, String smallString) {
        HashMap<Character, Integer> targetCharCounts = getMap(smallString);

        int startIndex = 0, endIndex = 0, uniqueCount = targetCharCounts.size();
        List<Integer> startIndices = new ArrayList<>();
        while (endIndex < bigString.length()) {
            char currentCharacter = bigString.charAt(endIndex);
            targetCharCounts.put(currentCharacter, targetCharCounts.getOrDefault(currentCharacter, 0) - 1);
            if (targetCharCounts.get(currentCharacter) == 0) {
                uniqueCount--;
            }

            if (endIndex - startIndex  + 1 > smallString.length()) {
                char startCharacter = bigString.charAt(startIndex);
                if (targetCharCounts.get(startCharacter) == 0) {
                    uniqueCount++;
                }
                targetCharCounts.put(startCharacter, targetCharCounts.get(startCharacter) + 1);
                startIndex++;
            }

            if (uniqueCount == 0) {
                startIndices.add(startIndex);
            }
            endIndex++;
        }
        return startIndices;
    }

    public HashMap<Character, Integer> getMap(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            map.put(current, map.getOrDefault(current, 0) + 1);
        }
        return map;
    }
}
