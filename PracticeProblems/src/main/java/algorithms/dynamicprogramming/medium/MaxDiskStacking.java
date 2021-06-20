package algorithms.dynamicprogramming.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxDiskStacking {
    public static List<Integer[]> diskStacking(List<Integer[]> disks) {
        int[] heights = new int[disks.size()];
        int[] sequences = new int[disks.size()];
        int maxIndex = 0;
        Arrays.fill(sequences, Integer.MIN_VALUE);
        Collections.sort(disks,(a, b)->a[2].compareTo(b[2]));
        for (int i = 0; i < disks.size(); i++) {
            heights[i] = disks.get(i)[2];
        }

        for (int i = 0; i < disks.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (areValid(disks.get(j), disks.get(i))) {
                    if (heights[i] <= heights[j] + disks.get(i)[2]) {
                        heights[i] = heights[j] + disks.get(i)[2];
                        sequences[i] = j;
                    }
                }
            }
            if (heights[i] >= heights[maxIndex]) {
                maxIndex = i;;
            }
        }
        return getSequence(disks, sequences, maxIndex);
    }

    public static boolean areValid(Integer[] a, Integer[] b) {
        return a[0] < b[0] && a[1] < b[1] && a[2] < b[2];
    }

    public static List<Integer[]>  getSequence(List<Integer[]> array, int[] sequences, int index) {
        List<Integer[]> sequence = new ArrayList<>();
        while (index != Integer.MIN_VALUE) {
            sequence.add(0, array.get(index));
            index = sequences[index];
        }
        return sequence;
    }
}
