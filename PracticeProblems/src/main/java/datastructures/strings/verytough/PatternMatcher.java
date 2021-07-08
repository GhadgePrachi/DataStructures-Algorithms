package datastructures.strings.verytough;

public class PatternMatcher {
    public static String[] patternMatcher(String pattern, String str) {
        int size = str.length();

        char mainChar = pattern.charAt(0);
        char altChar = mainChar == 'x' ? 'y' : 'x';
        int countOfMain = countOf(pattern, mainChar);
        int countOfAlt = pattern.length() - countOfMain;
        int firstAlt = pattern.indexOf(altChar);

        for (int mainSize = 0; mainSize <= (size / countOfMain); mainSize++) {
            int remainingLength = size - mainSize * countOfMain;
            String first = str.substring(0, mainSize);
            if (countOfAlt == 0 || remainingLength % countOfAlt == 0) {
                int altIndex = firstAlt * mainSize;
                int altSize = countOfAlt == 0 ? 0 : remainingLength / countOfAlt;
                String second = countOfAlt == 0 ? "" : str.substring(altIndex, altSize + altIndex);
                String candidate = buildFromPattern(pattern, first, second);
                if (candidate.equals(str)) {
                    if (countOfMain != 0 && first.isEmpty() || countOfAlt != 0 && second.isEmpty()) {
                        continue;
                    } else {
                        if (mainChar == 'x') {
                            return new String[] {first, second};
                        } else {
                            return new String[] {second, first};
                        }
                    }
                }
            }
        }
        return new String[] {};
    }

    public static String buildFromPattern(String pattern, String main, String alt) {
        StringBuilder sb = new StringBuilder();
        char first = pattern.charAt(0);
        for (char c : pattern.toCharArray()) {
            if (c == first) {
                sb.append(main);
            } else {
                sb.append(alt);
            }
        }
        return sb.toString();
    }

    public static int countOf(String pattern, char c) {
        int count = 0;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }
}
