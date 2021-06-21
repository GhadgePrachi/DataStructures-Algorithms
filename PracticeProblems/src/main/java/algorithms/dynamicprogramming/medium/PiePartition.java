package algorithms.dynamicprogramming.medium;

import java.util.Arrays;
import java.util.HashSet;

public class PiePartition {
    public static int numbersInPi(String pi, String[] numbers) {
        int[] minSpaces = new int[pi.length() + 1];
        Arrays.fill(minSpaces, Integer.MAX_VALUE);
        minSpaces[0] = 0;
        HashSet<String> uniqueNumbers = new HashSet<>();
        for (String number : numbers) {
            uniqueNumbers.add(number);
        }

        for (int i = 1; i <= pi.length(); i++) {
            for (int j = 0; j < i ; j++) {
                if (uniqueNumbers.contains(pi.substring(j,i))) {
                    if (minSpaces[j] != Integer.MAX_VALUE && minSpaces[i] > minSpaces[j] + 1) {
                        minSpaces[i] = minSpaces[j] + 1;
                    }
                }
            }
        }
        return minSpaces[pi.length()] == Integer.MAX_VALUE ? -1 : minSpaces[pi.length()] - 1;
    }
}
