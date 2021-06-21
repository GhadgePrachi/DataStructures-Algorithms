package algorithms.dynamicprogramming.medium;

import java.util.Arrays;
import java.util.HashSet;

public class WordPartition {
    public String longestWord(String[] words) {
        Arrays.sort(words, (a, b) -> b.length()-a.length());
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            set.add(words[i]);
        }

        for (int i = 0; i < words.length; i++) {
            if (canFormWords(words[i], set)) {
                return words[i];
            }
        }
        return "";
    }

    private boolean canFormWords(String word, HashSet<String> set) {
        boolean[] res = new boolean[word.length() + 1];
        res[0] = true;
        for (int i = 1; i <= word.length(); i++) {
            for (int j = 0; j < i; j++) {
                String right = word.substring(j,i);
                if (res[j] && !word.equals((right)) && set.contains(right)) {
                    res[i] = true;
                }
            }
        }
        return res[word.length()];
    }
}
