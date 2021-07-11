package algorithms.recursion.tough;

import java.util.HashMap;

public class InterweavingStrings {
    public static boolean interweavingStrings(String one, String two, String three) {
        if (three.length() != one.length() + two.length()) {
            return false;
        }

        HashMap<String, Boolean> canBeWoven = new HashMap<>();
        return areInterWoven(one, two, three, 0, 0, canBeWoven);
    }

    public static boolean areInterWoven(String one, String two, String three, int i, int j, HashMap<String, Boolean> canBeWoven) {
        String key = i + ":" + j;
        if (canBeWoven.containsKey(key)) {
            return canBeWoven.get(key);
        }

        if ((i+j) == three.length()) {
            return true;
        }

        Boolean result = false;
        if (i < one.length() && one.charAt(i) == three.charAt(i + j)) {
            result = areInterWoven(one, two, three, i + 1, j, canBeWoven);
            if (result) {
                canBeWoven.put(key, result);
                return result;
            }
        }

        if (j < two.length() && two.charAt(j) == three.charAt(i + j)) {
            result = areInterWoven(one, two, three, i, j + 1, canBeWoven);
            canBeWoven.put(key, result);
            return result;
        }

        canBeWoven.put(key, result);
        return result;
    }
}
