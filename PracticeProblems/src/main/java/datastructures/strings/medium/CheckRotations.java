package datastructures.strings.medium;

public class CheckRotations {
    public static boolean isRotation(String strOne, String strTwo){
        if(strOne.length() != strTwo.length()) {
            return false;
        }
        StringBuilder strOneRepeated = new StringBuilder();
        strOneRepeated.append(strOne);
        strOneRepeated.append(strOne);
        if (strOneRepeated.indexOf(strTwo) == -1) {
            return false;
        } else {
            return true;
        }
    }
}
