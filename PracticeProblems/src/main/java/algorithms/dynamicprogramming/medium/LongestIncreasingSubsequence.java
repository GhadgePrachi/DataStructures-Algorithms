package algorithms.dynamicprogramming.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static List<Integer> longestIncreasingSubsequence(int[] array) {
        int[] sequences = new int[array.length];
        Arrays.fill(sequences, Integer.MIN_VALUE);
        int[] lis = new int[array.length];
        Arrays.fill(lis, 1);
        int maxIndex = 0;

        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) {
                    if (lis[i] < lis[j] + 1) {
                        lis[i] = lis[j] + 1;
                        sequences[i] = j;
                    }
                }
            }
            if (lis[maxIndex] <= lis[i]) {
                maxIndex = i;
            }
        }

        return getSequence(sequences, maxIndex, array);
    }

    public static List<Integer> getSequence(int[] sequences, int index, int[] array) {
        List<Integer> sequence = new ArrayList<>();
        while (index != Integer.MIN_VALUE) {
            sequence.add(0, array[index]);
            index = sequences[index];
        }
        return sequence;
    }
}
