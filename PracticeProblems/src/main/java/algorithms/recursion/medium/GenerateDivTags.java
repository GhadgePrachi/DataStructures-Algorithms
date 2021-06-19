package algorithms.recursion.medium;

import java.util.ArrayList;

public class GenerateDivTags {
    public ArrayList<String> generateDivTags(int numberOfTags) {
        ArrayList<String> matchedString = new ArrayList<>();
        StringBuilder currentString = new StringBuilder();
        addParenthesis(matchedString, numberOfTags, numberOfTags, currentString);
        return matchedString;
    }

    public static void addParenthesis(ArrayList<String> list, int leftRem, int rightRem, StringBuilder str) {
        if (leftRem == 0 && rightRem == 0) {
            list.add(str.toString());
            return;
        }

        if (leftRem > 0) {
            int len = str.length();
            str.append("<div>");
            addParenthesis(list, leftRem - 1, rightRem, str);
            str.delete(len,str.length());
        }

        if (rightRem > leftRem) {
            int len = str.length();
            str.append("</div>");
            addParenthesis(list, leftRem, rightRem - 1, str);
            str.delete(len,str.length());
        }
    }
}
