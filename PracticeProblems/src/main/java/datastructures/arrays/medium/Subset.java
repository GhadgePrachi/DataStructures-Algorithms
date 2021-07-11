package datastructures.arrays.medium;

import java.util.HashSet;

public class Subset {
    public static int[] longestRange(int[] array) {
        int[] longestRange = new int[2];
        HashSet<Integer> set = new HashSet<>();

        for (int element : array) {
            set.add(element);
        }

        for (int element : array) {
            if (!set.contains(element - 1)) {
                int endElement = element + 1;
                while (set.contains(endElement)) {
                    endElement++;
                }
                endElement--;

                if (longestRange[1] - longestRange[0] <= endElement - element) {
                    longestRange = new int[] {element, endElement};
                }
            }
        }
        return longestRange;
    }
}
