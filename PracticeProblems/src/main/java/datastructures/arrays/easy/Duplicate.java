package datastructures.arrays.easy;

public class Duplicate {
    public int firstDuplicateValue(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[Math.abs(array[i]) - 1] < 0) {
                return Math.abs(array[i]);
            } else {
                array[Math.abs(array[i]) - 1] *= -1;
            }
        }
        return -1;
    }
}
