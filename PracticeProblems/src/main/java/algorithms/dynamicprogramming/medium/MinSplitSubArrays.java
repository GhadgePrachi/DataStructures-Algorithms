package algorithms.dynamicprogramming.medium;

public class MinSplitSubArrays {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int[][] maxSum = new int[k + 1][n + 1];
        int[] sum = new int[n + 1];

        for (int i = 0; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                maxSum[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        maxSum[0][0] = 0;
        for (int s = 1; s <= k; s++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    maxSum[s][i] = Math.min(maxSum[s][i], Math.max(maxSum[s - 1][j], sum[i] - sum[j]));
                }
            }
        }
        return maxSum[k][n];
    }
}
