package algorithms.dynamicprogramming.easy;

public class MaxSubsetSum {
    public static int maxSubsetSumNoAdjacent(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        int[] maxSum = new int[array.length];
        maxSum[0] = array[0];
        maxSum[1] = Math.max(array[0],array[1]);
        for (int i = 2; i < array.length; i++) {
            maxSum[i] = Math.max(array[i] + maxSum[i-2], maxSum[i-1]);
        }
        return maxSum[array.length - 1];
    }

    public static int maxSubsetSumNoAdjacentOptimal(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        int lastTwo = array[0];
        int lastOne = Math.max(array[0],array[1]);
        for (int i = 2; i < array.length; i++) {
            int localMax = Math.max(array[i] + lastTwo, lastOne);
            lastTwo = lastOne;
            lastOne = localMax;
        }
        return lastOne;
    }
}
