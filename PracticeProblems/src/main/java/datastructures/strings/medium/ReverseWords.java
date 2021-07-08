package datastructures.strings.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ReverseWords {
    public String reverseWordsInString(String str) {
        ArrayList<String> words = new ArrayList<>();
        int startIndex = 0;
        while (startIndex < str.length()) {
            int nextIndex = str.indexOf(' ', startIndex);
            if (nextIndex == -1) {
                nextIndex = str.length();
            }
            String sub = str.substring(startIndex, nextIndex);
            words.add(sub);
            if (nextIndex != str.length()) {
                words.add(" ");
            }
            startIndex = nextIndex + 1;
        }
        Collections.reverse(words);
        return String.join("", words);
    }

    public String reverseWordsInStringUsingSplit(String string) {
        String[] words = string.split(" ", -1);
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}
