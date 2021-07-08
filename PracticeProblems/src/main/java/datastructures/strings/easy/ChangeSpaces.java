package datastructures.strings.easy;

public class ChangeSpaces {
    public String  replaceSpace(String str, int trueLength){
        char[] array = str.toCharArray();
        //Get space count
        int spaceCount = 0;
        for (int i = 0; i < trueLength; i++) {
            if (array[i] == ' ') {
                spaceCount++;
            }
        }
        int index = trueLength + spaceCount * 2;

        //Format the string
        if (trueLength < array.length) {
            array[trueLength] = '\0';
        }
        for (int i = trueLength - 1; i >= 0; i--) {
            if (array[i] == ' ') {
                array[index - 1] = '0';
                array[index - 2] = '2';
                array[index - 3] = '%';
                index = index - 3;
            } else {
                array[index - 1] = array[i];
                index--;
            }
        }
        return new String(array);
    }
}
