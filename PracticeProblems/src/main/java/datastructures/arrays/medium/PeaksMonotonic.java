package datastructures.arrays.medium;

public class PeaksMonotonic {
    public static boolean isMonotonic(int[] array) {
        boolean isNonDecreasing = true;
        boolean isNonIncreasing = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                isNonIncreasing = false;
            } else if (array[i] > array[i + 1]) {
                isNonDecreasing = false;
            }
        }
        return isNonIncreasing || isNonDecreasing;
    }
}
