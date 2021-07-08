package datastructures.strings.easy;

public class CompressedEncryptor {
    public String runLengthEncoding(String str) {
        StringBuilder formattedString = new StringBuilder();
        char previousCharacter = str.charAt(0);
        int currentRunLength = 1;
        for (int i = 1; i < str.length(); i++){
            char currentCharacter = str.charAt(i);
            if (previousCharacter != currentCharacter || currentRunLength == 9){
                formattedString.append(currentRunLength);
                formattedString.append(previousCharacter);
                previousCharacter = currentCharacter;
                currentRunLength = 0;
            }
            currentRunLength++;
        }
        formattedString.append(currentRunLength);
        formattedString.append(previousCharacter);
        return formattedString.toString();
    }
}
