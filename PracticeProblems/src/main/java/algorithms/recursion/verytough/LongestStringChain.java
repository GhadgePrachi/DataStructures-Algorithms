package algorithms.recursion.verytough;

import java.util.*;

public class LongestStringChain {
    public static List<String> longestStringChain(List<String> strings) {
        List<String> sortedStrings = new ArrayList<>(strings);
        Collections.sort(sortedStrings, (a, b)->a.length() - b.length());

        Map<String, StringChain> stringChains = new HashMap<>();
        for (String string : strings) {
            stringChains.put(string, new StringChain("", 1));
        }
        for (String string : sortedStrings) {
            findLongestStringChain(string, stringChains);
        }
        return buildLongestStringChains(strings, stringChains);
    }

    public static void findLongestStringChain(String str, Map<String, StringChain> stringChains) {
        for (int i = 0; i < str.length(); i++) {
            String smallerString = str.substring(0,i) + str.substring(i+1);
            if (stringChains.containsKey(smallerString)) {
                int smallerLength = stringChains.get(smallerString).maxChainLength;
                int currentLength = stringChains.get(str).maxChainLength;
                if (smallerLength + 1 > currentLength) {
                    stringChains.get(str).maxChainLength = smallerLength + 1;
                    stringChains.get(str).nextString = smallerString;
                }
            }
        }
    }

    public static List<String> buildLongestStringChains(List<String> strings, Map<String, StringChain> stringChains) {
        int maxLength = 0;
        String chainStartingString = "";
        for (String string : strings) {
            if (stringChains.get(string).maxChainLength > maxLength) {
                maxLength = stringChains.get(string).maxChainLength;
                chainStartingString = string;
            }
        }

        List<String> longestStringChain = new ArrayList<>();
        String currentString = chainStartingString;
        while(currentString.equals("")) {
            longestStringChain.add(currentString);
            currentString = stringChains.get(currentString).nextString;
        }
        return longestStringChain.size() == 1 ? new ArrayList<>() : longestStringChain;
    }

    public static class StringChain {
        String nextString;
        int maxChainLength;

        public StringChain(String nextString, int maxChainLength) {
            this.nextString = nextString;
            this.maxChainLength = maxChainLength;
        }
    }
}
