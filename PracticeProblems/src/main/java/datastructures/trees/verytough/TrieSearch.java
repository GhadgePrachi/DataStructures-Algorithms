package datastructures.trees.verytough;

import java.util.*;

public class TrieSearch {
    /** Smaller String Search **/
    public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
        Trie trie = new Trie(bigString);
        List<Boolean> solution = new ArrayList<>();
        for (String smallString : smallStrings) {
            solution.add(trie.contains(smallString));
        }
        return solution;
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
    }

    static class Trie {
        TrieNode root = new TrieNode();

        public Trie(String str) {
            populateSuffixTrie(str);
        }

        public void populateSuffixTrie(String str) {
            for (int i = 0; i < str.length(); i++) {
                insert(str.substring(i));
            }
        }

        public void insert(String str) {
            TrieNode current = root;
            for (int i = 0; i < str.length(); i++) {
                char letter = str.charAt(i);
                if (!current.children.containsKey(letter)) {
                    TrieNode newNode = new TrieNode();
                    current.children.put(letter, newNode);
                }
                current = current.children.get(letter);
            }
        }

        public boolean contains(String str) {
            TrieNode current = root;
            for (int i = 0; i < str.length(); i++) {
                char letter = str.charAt(i);
                if (!current.children.containsKey(letter))
                    return false;
                current = current.children.get(letter);
            }
            return true;
        }
    }

    /** Bigger String Search **/
    public static List<Boolean> multiStringSearchModified(String bigString, String[] smallStrings) {
        TrieModified trie = new TrieModified();
        for (String smallString : smallStrings) {
            trie.insert(smallString);
        }

        Set<String> contained = new HashSet<>();
        for (int i = 0; i < bigString.length(); i++) {
            containSmallString(bigString, i, trie, contained);
        }

        List<Boolean> solution = new ArrayList<>();
        for (String smallString : smallStrings) {
            solution.add(contained.contains(smallString));
        }
        return solution;
    }

    public static void containSmallString(String str, int startIndex, TrieModified trie, Set<String> contained) {
        TrieNodeModified current = trie.root;

        for (int i = startIndex; i < str.length(); i++) {
            char letter = str.charAt(i);
            if (!current.children.containsKey(letter)) {
                break;
            }
            current = current.children.get(letter);
            if (current.children.containsKey(trie.endSymbol)) {
                contained.add(current.word);
            }
        }
    }

    static class TrieNodeModified {
        Map<Character, TrieNodeModified> children = new HashMap<>();
        String word;
    }

    static class TrieModified {
        TrieNodeModified root = new TrieNodeModified();
        char endSymbol = '*';

        public void insert(String str) {
            TrieNodeModified current = root;
            for (int i = 0; i < str.length(); i++) {
                char letter = str.charAt(i);
                if (!current.children.containsKey(letter)) {
                    TrieNodeModified newNode = new TrieNodeModified();
                    current.children.put(letter, newNode);
                }
                current = current.children.get(letter);
            }
            current.children.put(endSymbol, null);
            current.word = str;
        }
    }
}