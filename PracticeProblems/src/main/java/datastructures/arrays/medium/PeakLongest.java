package datastructures.arrays.medium;

public class PeakLongest {
    public static int longestPeak(int[] array) {
        int longest = 0;
        for (int i = 1; i < array.length - 1; i++) {
            int start = getLongestOrdered(i, array, false);
            int end = getLongestOrdered(i, array, true);
            if (start == i || end == i) {
                continue;
            }
            if (longest < end - start + 1){
                longest = end - start + 1;
            }
        }
        return longest;
    }

    public static int getLongestOrdered(int start,int[] array, boolean increasing) {
        if (increasing) {
            while (start < array.length - 1 && array[start] > array[start + 1]) {
                start++;
            }
        } else {
            while (start > 0 && array[start - 1] < array[start]) {
                start--;
            }
        }
        return start;
    }
}
