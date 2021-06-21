package algorithms.dynamicprogramming.tough;

public class LevenshteinDistance {
    public static int levenshteinDistance(String str1, String str2) {
        int[][] editDistance = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                if (i == 0) {
                    editDistance[i][j] = j;
                }else if (j == 0) {
                    editDistance[i][j] = i;
                } else if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    editDistance[i][j] = editDistance[i-1][j-1];
                } else {
                    editDistance[i][j] = Math.min(editDistance[i-1][j-1],Math.min(editDistance[i-1][j], editDistance[i][j-1])) + 1;
                }
            }
        }
        return editDistance[str1.length()][str2.length()];
    }
}
