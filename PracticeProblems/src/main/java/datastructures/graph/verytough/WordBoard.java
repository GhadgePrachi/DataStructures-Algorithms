package datastructures.graph.verytough;

import java.util.*;

public class WordBoard {
    static int[] directionRow = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] directionCol = {0, 0, 1, -1, 1, -1, 1, -1};
    static char END_SYMBOL = '*';

    public static List<String> boggleBoard(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        Set<String> finalWords = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                search(row, col, board, trie.root, visited, finalWords);
            }
        }
        List<String> finalWordsArray = new ArrayList<>();
        finalWordsArray.addAll(finalWords);
        return finalWordsArray;
    }

    public static void search(int row, int col, char[][] board, TrieNode trieNode, boolean[][] visited, Set<String> finalWords) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length || visited[row][col] || !trieNode.children.containsKey(board[row][col])) {
            return;
        }

        visited[row][col] = true;
        char letter = board[row][col];
        trieNode = trieNode.children.get(letter);

        if (trieNode.children.containsKey(END_SYMBOL)) {
            finalWords.add(trieNode.word);
        }

        for (int direction = 0; direction < 8; direction++) {
            int nextRow = row + directionRow[direction];
            int nextCol = col + directionCol[direction];
            search(nextRow, nextCol, board, trieNode, visited, finalWords);
        }

        visited[row][col] = false;
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word = "";
    }

    static class Trie {
        TrieNode root;
        char endSymbol;

        public Trie() {
            root = new TrieNode();
            endSymbol = '*';
        }

        public void insert(String str) {
            TrieNode current = root;
            for (int j = 0; j < str.length(); j++) {
                char letter = str.charAt(j);
                if (!current.children.containsKey(letter)) {
                    TrieNode newNode = new TrieNode();
                    current.children.put(letter, newNode);
                }
                current = current.children.get(letter);
            }
            current.children.put(this.endSymbol, null);
            current.word = str;
        }
    }
}
