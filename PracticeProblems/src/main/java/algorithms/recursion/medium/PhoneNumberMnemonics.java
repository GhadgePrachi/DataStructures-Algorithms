package algorithms.recursion.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneNumberMnemonics {
    public static Map<Character, String[]> digitLetters;
    public ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
        digitLetters = setUpDictionary();
        ArrayList<String> phoneNumberMnemonicsList = new ArrayList<>();
        phoneNumberMnemonics(phoneNumber, 0, new StringBuilder(), phoneNumberMnemonicsList);
        return phoneNumberMnemonicsList;
    }

    public static void phoneNumberMnemonics (String phoneNumber, int index, StringBuilder currentPhoneNumberMnemonics, ArrayList<String> phoneNumberMnemonicsList) {
        if (index == phoneNumber.length()) {
            phoneNumberMnemonicsList.add(currentPhoneNumberMnemonics.toString());
            return;
        }

        char phoneNumberDigit = phoneNumber.charAt(index);
        String[] possibleLetters = digitLetters.get(phoneNumberDigit);
        for (String letter : possibleLetters) {
            currentPhoneNumberMnemonics.append(letter);
            phoneNumberMnemonics(phoneNumber, index + 1, currentPhoneNumberMnemonics, phoneNumberMnemonicsList);
            currentPhoneNumberMnemonics.deleteCharAt(currentPhoneNumberMnemonics.length() - 1);
        }

    }

    public static Map<Character, String[]> setUpDictionary() {
        Map<Character, String[]> digitLetters = new HashMap<>();
        digitLetters.put('0', new String[] {"0"});
        digitLetters.put('1', new String[] {"1"});
        digitLetters.put('2', new String[] {"a", "b", "c"});
        digitLetters.put('3', new String[] {"d", "e", "f"});
        digitLetters.put('4', new String[] {"g", "h", "i"});
        digitLetters.put('5', new String[] {"j", "k", "l"});
        digitLetters.put('6', new String[] {"m", "n", "o"});
        digitLetters.put('7', new String[] {"p", "q", "r", "s"});
        digitLetters.put('8', new String[] {"t", "u", "v"});
        digitLetters.put('9', new String[] {"w", "x", "y", "z"});
        return digitLetters;
    }
}
