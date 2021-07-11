package datastructures.arrays.easy;

import java.util.Arrays;

public class Difference {
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int i = 0, j = 0;
        int minDifference = Integer.MAX_VALUE;
        int[] smallestDifference = new int[2];

        while (i < arrayOne.length && j < arrayTwo.length) {
            int firstElement = arrayOne[i];
            int secondElement = arrayTwo[j];
            int difference = Math.abs(firstElement - secondElement);
            if (difference < minDifference) {
                minDifference = difference;
                smallestDifference = new int[] {firstElement, secondElement};
            }

            if (firstElement < secondElement){
                i++;
            } else if (firstElement > secondElement) {
                j++;
            } else {
                return new int[] {firstElement, secondElement};
            }
        }
        return smallestDifference;
    }
}
