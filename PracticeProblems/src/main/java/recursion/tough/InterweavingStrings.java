package recursion.tough;

public class InterweavingStrings {
    public static boolean interweavingStrings(String one, String two, String three) {
        if (three.length() != one.length() + two.length())
            return false;

        Boolean[][] canBeWoven = new Boolean[one.length()+1][two.length()+1];
        return areInterWoven(one, two, three, 0, 0, canBeWoven);
    }

    public static boolean areInterWoven(String one, String two, String three, int i, int j, Boolean[][] canBeWoven) {
        int k = i+j;

        if (k == three.length()) {
            return true;
        }

        if (canBeWoven[i][j] != null) {
            return canBeWoven[i][j];
        }

        if (i < one.length() && one.charAt(i) == three.charAt(k)) {
            canBeWoven[i][j] = areInterWoven(one, two, three, i + 1, j, canBeWoven);
            if (canBeWoven[i][j]) {
                return canBeWoven[i][j];
            }
        }

        if (j < two.length() && two.charAt(j) == three.charAt(k)) {
            canBeWoven[i][j] = areInterWoven(one, two, three, i, j + 1, canBeWoven);
            return canBeWoven[i][j];
        }

        canBeWoven[i][j] = false;
        return false;
    }
}
