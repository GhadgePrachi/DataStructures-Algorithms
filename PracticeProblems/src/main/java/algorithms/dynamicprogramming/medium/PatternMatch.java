package algorithms.dynamicprogramming.medium;

public class PatternMatch {
    public boolean wildCardMatch(String text, String pattern) {
        if (text == null || pattern == null) {
            return false;
        }

        if (text.length() == 0) {
            return pattern.length() == 0 ? true : false;
        }

        boolean[][] wildCard = new boolean[text.length() + 1][pattern.length() + 1];
        wildCard[0][0] = true;
        for (int j = 1; j < pattern.length(); j++) {
            if (pattern.charAt(j - 1) == '*' && wildCard[0][j - 1]) {
                wildCard[0][j] = true;
            }
        }

        for (int i = 1; i <= text.length(); i++) {
            for (int j = 1; j <= pattern.length(); j++) {
                if (text.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '?') {
                    wildCard[i][j] = wildCard[i - 1][j - 1];
                } else if (pattern.charAt(j - 1) == '*') {
                    wildCard[i][j] = wildCard[i][j - 1]  || wildCard[i - 1][j];
                } else {
                    wildCard[i][j] = false;
                }
            }
        }

        return wildCard[text.length()][pattern.length()];
    }

    public boolean regularExpressionMatch(String text, String pattern) {
        if (text == null || pattern == null) {
            return false;
        }

        boolean[][] regularExpression = new boolean[text.length() + 1][pattern.length() + 1];
        regularExpression[0][0] = true;
        for (int j = 1; j < regularExpression[0].length; j++) {
            if (pattern.charAt(j - 1) == '*' && (regularExpression[0][j - 1] || (j > 1 && regularExpression[0][j - 2]))) {
                regularExpression[0][j] = true;
            }
        }

        for (int i = 1; i <= text.length(); i++) {
            for (int j = 1; j <= pattern.length(); j++) {
                if (text.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.') {
                    regularExpression[i][j] = regularExpression[i - 1][j - 1];
                }else if (pattern.charAt(j - 1) == '*') {
                    regularExpression[i][j] = regularExpression[i][j - 2];
                    if (pattern.charAt(j - 2) == text.charAt(i - 1) || pattern.charAt(j - 2) == '.') {
                        regularExpression[i][j] = regularExpression[i - 1][j]  || regularExpression[i][j];
                    }
                }else
                    regularExpression[i][j] = false;
            }
        }

        return regularExpression[text.length()][pattern.length()];
    }
}
