package datastructures.strings.easy;

import java.util.HashMap;

public class FirstNonRepeatingCharacter {
    public int firstNonRepeatingCharacter(String str) {
        HashMap<Character, Integer> frequencyMap = getMap(str);
        for (int i = 0; i < str.length(); i++){
            if (frequencyMap.get(str.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }

    public static HashMap<Character, Integer> getMap(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++){
            char currentCharacter = str.charAt(i);
            map.put(currentCharacter, map.getOrDefault(currentCharacter,0)+1);
        }
        return map;
    }
}
