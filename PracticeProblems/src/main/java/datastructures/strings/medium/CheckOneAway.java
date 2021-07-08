package datastructures.strings.medium;

public class CheckOneAway {
    public static boolean oneEditAwaySeparateFunctions(String strOne, String strTwo) {
        if (strOne.length() == strTwo.length()) {
            return oneEditReplace(strOne, strTwo);
        } else if (strOne.length() + 1 == strTwo.length()) {
            return oneEditInsert(strOne, strTwo);
        } else if (strOne.length() - 1 == strTwo.length()) {
            return oneEditInsert(strTwo, strOne);
        }
        return false;
    }

    public static boolean oneEditReplace(String strOne, String strTwo) {
        boolean foundDifference = false;
        for (int i = 0; i < strOne.length(); i++) {
            if (strOne.charAt(i) != strTwo.charAt(i)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }

    public static boolean oneEditInsert(String strOne, String strTwo) {
        int index = 0;
        for (int i = 0; i < strTwo.length(); i++) {
            if (strOne.charAt(index) != strTwo.charAt(i)) {
                if (index != i) {
                    return false;
                }
            } else {
                index++;
            }
        }
        return true;
    }

    public static boolean oneEditAway(String strOne, String strTwo) {
        if (Math.abs(strOne.length() - strTwo.length()) > 1) {
            return false;
        }
        String s1 = strOne.length() < strTwo.length() ? strOne : strTwo;
        String s2 = strOne.length() < strTwo.length() ? strTwo : strOne;
        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
                if (s1.length() == s2.length()) {
                    index1++;
                }
            } else {
                index1++;
            }
            index2++;
        }
        return true;
    }
}
