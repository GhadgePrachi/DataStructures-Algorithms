package datastructures.trees.verytough;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    }

    static class SuffixTrie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public SuffixTrie(String str) {
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
            current.children.put(endSymbol, null);
        }

        public boolean contains(String str) {
            TrieNode current = root;
            for (int i = 0; i < str.length(); i++) {
                char letter = str.charAt(i);
                if (!current.children.containsKey(letter)) {
                    return false;
                } else {
                    current = current.children.get(letter);
                }
            }
            return current.children.containsKey(endSymbol);
        }

        public boolean delete(String str) {
            return delete(str, 0);
        }

        public boolean delete(String str, int index) {
            TrieNode current = root;
            if (str != null) {
                if (index == str.length()) {
                    if (current.children.containsKey(endSymbol)) {
                        current.children.remove(endSymbol);
                        return current.children.size() == 0;
                    } else {
                        return false;
                    }
                }

                char letter = str.charAt(index);
                if (current.children.containsKey(letter) && this.delete(str, index + 1)) {
                        current.children.remove(letter);
                        return current.children.size() == 0;
                } else {
                    return false;
                }
            }
            return false;
        }
    }
}