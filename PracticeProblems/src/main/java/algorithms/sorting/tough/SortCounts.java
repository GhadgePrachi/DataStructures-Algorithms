package algorithms.sorting.tough;

import java.util.*;

public class SortCounts {
    public static List<List<String>> sortFrequencies(List<String> book) {
        HashMap<String, Integer> wordFrequencies = setUpDictionary(book);
        TreeMap<Integer, List<String>> sortedWords = setUpSortedDictionary(wordFrequencies);
        return new ArrayList<>(sortedWords.values());
    }

    public static HashMap<String, Integer> setUpDictionary(List<String> array) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String element : array) {
            element = element.toLowerCase();
            if (!element.trim().equals("")){
                map.put(element, map.getOrDefault(element, 0) + 1);
            }
        }
        return map;
    }

    public static TreeMap<Integer, List<String>> setUpSortedDictionary(HashMap<String, Integer> map) {
        TreeMap<Integer, List<String>> sortedMap = new TreeMap<>();
        for (String word : map.keySet()) {
            int frequency = map.get(word);
            List<String> list = sortedMap.getOrDefault(frequency, new ArrayList<>());
            list.add(word);
            sortedMap.put(frequency, list);
        }
        return sortedMap;
    }
}
