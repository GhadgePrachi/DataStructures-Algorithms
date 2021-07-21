package datastructures.arrays.verytough;

import java.util.HashSet;
import java.util.Set;

public class Cycles {
    public static boolean hasSingleCycle(int[] array) {
        Set<Integer> visitedIndices = new HashSet<>();
        int startIndex = 0;
        int index = startIndex;
        int indicesCount = array.length;

        while (indicesCount > 0 && !visitedIndices.contains(index)) {
            visitedIndices.add(index);
            indicesCount--;
            index = getNextIndex(index, array);
        }
        return indicesCount == 0 && index == startIndex ? true : false;
    }

    public static int getNextIndex(int index, int[] array) {
        int jump = array[index];
        int nextIndex = (index + jump ) % array.length;
        if (nextIndex >= 0) {
            return nextIndex;
        } else
            return array.length + nextIndex;
    }
}
