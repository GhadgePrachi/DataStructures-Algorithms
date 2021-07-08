package datastructures.strings.easy;

import java.util.HashMap;

public class GenerateDocuments {
    public boolean generateDocument(String characters, String document) {
        HashMap<Character, Integer> frequencyMap = getMap(characters);
        return contains(frequencyMap, document);

    }

    public static HashMap<Character, Integer> getMap(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++){
            char currentCharacter = str.charAt(i);
            map.put(currentCharacter, map.getOrDefault(currentCharacter,0)+1);
        }
        return map;
    }

    public boolean contains(HashMap<Character, Integer> map, String str){
        for (int i = 0; i < str.length(); i++){
            char currentCharacter = str.charAt(i);
            if (!map.containsKey(currentCharacter)){
                return false;
            }else{
                int frequency = map.get(currentCharacter);
                if (--frequency == 0){
                    map.remove(currentCharacter);
                }else{
                    map.put(currentCharacter, frequency);
                }
            }
        }
        return true;
    }
}
