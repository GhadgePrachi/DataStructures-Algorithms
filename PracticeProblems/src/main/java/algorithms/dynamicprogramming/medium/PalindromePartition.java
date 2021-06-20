package algorithms.dynamicprogramming.medium;

import java.util.Arrays;

public class PalindromePartition {
    public static int palindromePartitioningMinCuts(String str) {
        boolean[][] isPalindrome = new boolean[str.length()][str.length()];
        for (int i = 0; i < str.length(); i++) {
            isPalindrome[i][i] = true;
        }

        for (int i = 2; i <= str.length(); i++) {
            for (int j = 0; j < str.length() - i + 1; j++) {
                int start = j;
                int end = j + i - 1;
                if (str.charAt(start) == str.charAt(end)) {
                    if (i == 2) {
                        isPalindrome[start][end] = true;
                    } else {
                        isPalindrome[start][end] = isPalindrome[start + 1][end - 1];
                    }
                }
            }
        }

        int[] cuts = new int[str.length() + 1];
        Arrays.fill(cuts, Integer.MAX_VALUE);
        cuts[0] = 0;

        for (int i = 1; i <= str.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j][i - 1]) {
                    if (cuts[j] != Integer.MAX_VALUE && cuts[i] > cuts[j] + 1 ) {
                        cuts[i] = cuts[j] + 1;
                    }
                }
            }
        }
        return cuts[str.length()] - 1;
    }
}
