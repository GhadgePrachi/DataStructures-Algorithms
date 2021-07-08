package datastructures.strings.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinimumCharactersForWords {
    public String[] minimumCharactersForWords(String[] words) {
        HashMap<Character, Integer> wordsFrequencies = new HashMap<>();
        for (String word : words){
            HashMap<Character, Integer> wordFrequencies = getFrequencies(word);
            update(wordFrequencies, wordsFrequencies);
        }

        List<String> smallestArray = convertToArray(wordsFrequencies);
        return smallestArray.toArray(new String[smallestArray.size()]);
    }

    public static HashMap<Character, Integer> getFrequencies(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char currentCharacter = str.charAt(i);
            map.put(currentCharacter, map.getOrDefault(currentCharacter, 0) + 1);
        }
        return map;
    }

    public static void update(HashMap<Character, Integer> mapOne, HashMap<Character, Integer> mapTwo) {
        for (char currentCharacter : mapOne.keySet()) {
            int currentCount = mapOne.get(currentCharacter);
            int count = mapTwo.getOrDefault(currentCharacter, 0);
            if (currentCount > count) {
                mapTwo.put(currentCharacter, currentCount);
            }
        }
    }

    public static List<String> convertToArray(HashMap<Character, Integer> map) {
        List<String> smallestArray = new ArrayList<>();
        for (char currentCharacter: map.keySet()) {
            int frequency = map.get(currentCharacter);
            add(currentCharacter, frequency, smallestArray);
        }
        return smallestArray;
    }

    public static void add(char value, int count, List<String> array) {
        while (count > 0) {
            array.add(Character.toString(value));
            count -= 1;
        }
    }
}
