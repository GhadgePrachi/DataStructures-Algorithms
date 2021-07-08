package datastructures.strings.easy;

public class CipherEncryptor {
    public static String caesarCypherEncryptor(String str, int key) {
        char[] rotatedString = new char[str.length()];
        for (int i = 0 ; i < str.length(); i++){
            rotatedString[i] = rotate(str.charAt(i), key);
        }
        return new String(rotatedString);
    }

    public static char rotate(Character ch, int key){
        int start = 97, end = 122, totalCharacters = 26;
        int val = (int)ch ;
        key %= totalCharacters;
        val += key;
        if (val > end) {
            val = start + (val % (end + 1));
        }
        return (char)val;
    }
}
