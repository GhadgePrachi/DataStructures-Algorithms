package datastructures.strings.tough;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        StringBuilder line;
        int startIndex = 0, endIndex = 0, lineSize = 0;
        while (endIndex < words.length) {
            int delimiterCount = endIndex - startIndex;
            if ((lineSize + words[endIndex].length() + delimiterCount) > maxWidth) {
                line = formLine(maxWidth, lineSize, startIndex, endIndex, words);
                result.add(line.toString());
                lineSize = 0;
                startIndex = endIndex;
            }
            lineSize += (words[endIndex].length());

            if (endIndex == words.length - 1) {
                line = formLastLine(maxWidth, lineSize, startIndex, endIndex + 1, words);
                result.add(line.toString());
            }
            endIndex++;
        }
        return result;
    }

    public StringBuilder formLastLine(int maxWidth, int lineSize, int startIndex, int endIndex, String[] words) {
        StringBuilder line = new StringBuilder();
        int delimiterCount = endIndex - startIndex;
        for (int i = 0; i < endIndex - startIndex; i++) {
            line.append(words[startIndex + i]);
            if ((i == endIndex - startIndex - 1)) {
                add(line, ' ', maxWidth - (lineSize + delimiterCount - 1));
            } else {
                add(line, ' ', 1);
            }
        }
        return line;
    }

    public StringBuilder formLine(int maxWidth, int lineSize, int startIndex, int endIndex, String[] words) {
        StringBuilder line = new StringBuilder();
        int delimiterCount = endIndex - startIndex;
        int totalSpaces = maxWidth - lineSize;
        int minDelimiterSize = totalSpaces;
        int additionalDelimiterSize = 0;

        if (delimiterCount > 1) {
            minDelimiterSize = totalSpaces / (delimiterCount - 1);
            additionalDelimiterSize = totalSpaces % (delimiterCount - 1);
        }

        for (int i = 0; i < endIndex - startIndex; i++) {
            line.append(words[startIndex + i]);
            if ((i != endIndex - startIndex - 1) || (endIndex == startIndex + 1)) {
                add(line, ' ', minDelimiterSize + (additionalDelimiterSize > i ? 1 : 0));
            }
        }
        return line;
    }

    public void add(StringBuilder line, char ch, int count) {
        while (count > 0) {
            line.append(ch);
            count--;
        }
    }
}
