package datastructures.strings.tough;

public class LongestBalancedSubstring {
    public int longestBalancedSubstring(String str) {
        //Left to Right
        int count = 0, maxlength = 0;
        int startIndex = 0, endIndex = 0;
        while (endIndex < str.length()) {
            if (str.charAt(endIndex) == '(') {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                maxlength = Math.max(maxlength, endIndex - startIndex + 1);
            } else if (count <= 0) {
                count = 0;
                startIndex = endIndex + 1;
            }
            endIndex++;
        }

        //Right to left
        startIndex = str.length() - 1;
        endIndex = str.length() - 1;
        count = 0;
        while (endIndex >= 0) {
            if (str.charAt(endIndex) == '(') {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                maxlength = Math.max(maxlength, startIndex - endIndex + 1);
            } else if (count >= 0) {
                count = 0;
                startIndex = endIndex - 1;
            }
            endIndex--;
        }
        return maxlength;
    }

    public int longestBalancedSubstringOptimal(String string) {
        return Math.max(getLongestBalanced(string, true), getLongestBalanced(string, false));
    }

    public int getLongestBalanced(String string, boolean leftToRight) {
        int startIndex = leftToRight ? 0 : string.length() - 1;
        int endIndex = leftToRight ? 0 : string.length() - 1;
        int step = leftToRight ? 1 : -1;
        int maxLength = 0, count = 0;

        while (endIndex >= 0 && endIndex < string.length()) {
            char current = string.charAt(endIndex);
            if (current == '(') {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                maxLength = Math.max(maxLength, Math.abs(endIndex - startIndex) + 1);
            } else if (leftToRight && count <= 0) {
                count = 0;
                startIndex = endIndex + 1;
            } else if (!leftToRight && count >= 0) {
                count = 0;
                startIndex = endIndex - 1;
            }
            endIndex += step;
        }
        return maxLength;
    }
}
