package algorithms.dynamicprogramming.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumIncreasingSubsequence {
    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
        int[] lis = array.clone();
        int[] sequences = new int[array.length];
        Arrays.fill(sequences, Integer.MAX_VALUE);
        int maxIndex = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) {
                    if (lis[i] < lis[j] + array[i]) {
                        lis[i] = lis[j] + array[i];
                        sequences[i] = j;
                    }
                }
            }
            if(lis[i] >= lis[maxIndex]) {
                maxIndex = i;
            }
        }
        return getSequence(array, sequences, maxIndex, lis[maxIndex]);
    }

    public static List<List<Integer>> getSequence(int[] array, int[] sequences, int index, int sums) {
        List<List<Integer>> sequence = new ArrayList<>();
        sequence.add(new ArrayList<Integer>());
        sequence.add(new ArrayList<Integer>());
        sequence.get(0).add(sums);

        while (index != Integer.MAX_VALUE) {
            sequence.get(1).add(0,array[index]);
            index = sequences[index];
        }
        return sequence;
    }
}
