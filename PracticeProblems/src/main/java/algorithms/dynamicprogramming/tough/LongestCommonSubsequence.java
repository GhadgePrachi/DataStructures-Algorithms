package algorithms.dynamicprogramming.tough;

import java.util.LinkedList;
import java.util.List;

public class LongestCommonSubsequence {
    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        int[][] lcs = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 1 ; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }

        return buildSequence(lcs, str1);
    }

    public static List<Character> buildSequence(int[][] lcs, String str) {
        List<Character> sequence = new LinkedList<>();
        int i = lcs.length - 1;
        int j = lcs[0].length - 1;

        while (i > 0 && j > 0) {
            if (lcs[i][j] == lcs[i - 1][j]) {
                i -= 1;
            } else if (lcs[i][j] == lcs[i][j - 1]) {
                j -= 1;
            } else {
                sequence.add(0, str.charAt(i - 1));
                i -= 1;
                j -= 1;;
            }
        }
        return sequence;
    }
}
