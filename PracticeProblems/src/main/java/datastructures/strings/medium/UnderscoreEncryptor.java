package datastructures.strings.medium;

import java.util.ArrayList;
import java.util.List;

public class UnderscoreEncryptor {
    public static String underScorifySubstring(String str, String substring) {
        List<Integer[]> locations = collapse(getLocations(str, substring));
        return underscorify(str, locations);
    }

    public static List<Integer[]> getLocations(String str, String substring) {
        List<Integer[]> locations = new ArrayList<>();
        int startIndex = 0;
        while(startIndex < str.length()) {
            int nextIndex = str.indexOf(substring, startIndex);
            if (nextIndex != -1) {
                locations.add(new Integer[] {nextIndex, nextIndex + substring.length()});
                startIndex = nextIndex + 1;
            } else {
                break;
            }
        }
        return locations;
    }

    public static List<Integer[]> collapse(List<Integer[]> locations) {
        List<Integer[]> newLocations = new ArrayList<>();
        Integer[] prev = new Integer[2];
        for (int i = 0; i < locations.size(); i++) {
            Integer[] current = locations.get(i);
            if (i != 0 && prev[1] >= current[0]) {
                prev[1] = current[1];
            } else {
                newLocations.add(current);
                prev = current;
            }
        }

        return newLocations;
    }

    public static String underscorify(String str, List<Integer[]> locations) {
        StringBuilder formattedString = new StringBuilder();
        int index = 0;
        for (Integer[] location : locations) {
            formattedString.append(str.substring(index,location[0]));
            formattedString.append("_");
            formattedString.append(str.substring(location[0], location[1]));
            formattedString.append("_");
            index = location[1];
        }
        if (index < str.length()) {
            formattedString.append(str.substring(index));
        }
        return formattedString.toString();
    }
}
