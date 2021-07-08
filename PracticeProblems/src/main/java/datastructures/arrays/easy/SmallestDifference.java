package datastructures.arrays.easy;

import java.util.Arrays;

public class SmallestDifference {
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int i = 0, j = 0;
        int minDifference = Integer.MAX_VALUE, difference;
        int[] smallestDifference = new int[2];

        while(i < arrayOne.length && j < arrayTwo.length){
            int firstlement = arrayOne[i];
            int secondElement = arrayTwo[j];
            if (firstlement < secondElement){
                difference = secondElement - firstlement;
                i += 1;
            }else if (firstlement > secondElement){
                difference = firstlement- secondElement;
                j += 1;
            }else{
                return new int[]{firstlement, secondElement};
            }

            if (difference < minDifference){
                minDifference = difference;
                smallestDifference = new int[] {firstlement, secondElement};
            }
        }
        return smallestDifference;
    }
}
