package algorithms.dynamicprogramming.medium;

public class MinSplitSubArrays {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] maxSum = new int[n + 1][m + 1];
        int[] sub = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                maxSum[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < n; i++) {
            sub[i + 1] = sub[i] + nums[i];
        }

        maxSum[0][0] = 0;
        for (int j = 1; j <= m; j++) {
            for (int i = 1; i <= n; i++) {
                for (int k = 0; k < i; k++) {
                    maxSum[i][j] = Math.min(maxSum[i][j], Math.max(maxSum[k][j - 1], sub[i] - sub[k]));
                }
            }
        }
        return maxSum[n][m];
    }
}
