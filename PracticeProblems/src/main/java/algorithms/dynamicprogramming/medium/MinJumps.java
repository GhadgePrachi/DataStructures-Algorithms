package algorithms.dynamicprogramming.medium;

import java.util.Arrays;

public class MinJumps {
    public static int minNumberOfJumps(int[] array) {
        int[] minJumps = new int[array.length];
        Arrays.fill(minJumps, Integer.MAX_VALUE);
        minJumps[0] = 0;
        int localMin = 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (j + array[j] >= i) {
                    if (minJumps[j] != Integer.MAX_VALUE) {
                        localMin = minJumps[j] + 1;
                    } else {
                        localMin = minJumps[j];
                    }
                    minJumps[i] = Math.min(minJumps[i], localMin);
                }
            }
        }
        return minJumps[array.length - 1];
    }
}
