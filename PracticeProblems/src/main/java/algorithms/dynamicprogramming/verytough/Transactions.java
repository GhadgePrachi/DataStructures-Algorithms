package algorithms.dynamicprogramming.verytough;

public class Transactions {
    public static int maxProfitWithKTransactions(int[] prices, int k) {
        int[][] maxProfit = new int[k + 1][prices.length + 1];

        for (int i = 0; i <= k; i++) {
            maxProfit[i][0] = 0;
        }

        for (int i = 0; i <= prices.length; i++) {
            maxProfit[0][i] = 0;
        }

        if (prices.length == 0) {
            return 0;
        }

        for (int t = 1; t <= k; t++) {
            for (int i = 1; i < prices.length; i++) {
                int currentMax = Integer.MIN_VALUE;
                for (int j = 0; j < i; j++) {
                    currentMax = Math.max(maxProfit[t - 1][j] - prices[j], currentMax);
                    maxProfit[t][i] = Math.max(currentMax + prices[i], maxProfit[t][i - 1]);
                }
            }
        }
        return maxProfit[k][prices.length - 1];
    }
}