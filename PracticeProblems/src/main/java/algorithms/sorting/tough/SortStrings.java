package algorithms.sorting.tough;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SortStrings {
    public static List<List<String>> groupAnagrams(List<String> words) {
        HashMap<String, List<String>> anagrams = setUpDictionary(words);
        return new ArrayList<>(anagrams.values());
    }

    public static HashMap<String, List<String>> setUpDictionary(List<String> words) {
        HashMap<String, List<String>> mapList = new HashMap<>();

        for (String s : words) {
            String key = sortChars(s);
            List<String> list = mapList.getOrDefault(key, new ArrayList<>());
            list.add(s);
            mapList.put(key, list);
        }
        return mapList;
    }

    public static String sortChars(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
}
