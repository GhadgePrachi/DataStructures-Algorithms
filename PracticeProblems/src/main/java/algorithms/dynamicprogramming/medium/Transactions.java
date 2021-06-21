package algorithms.dynamicprogramming.medium;

public class Transactions {
    public static int maxProfitWithOneTransaction(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int min = prices[0], maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return maxProfit;
    }

    public static int maxProfitWithTwoTransactions(int[] prices) {
        int leftMin = prices[0];
        int rightMax = prices[prices.length - 1];
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];

        for (int i = 1; i < prices.length; i++){
            left[i] = Math.max(left[i - 1], prices[i] - leftMin);
            leftMin = Math.min(leftMin, prices[i]);
        }

        for (int i = prices.length - 2; i >= 0; i--){
            right[i] = Math.max(right[i + 1], rightMax - prices[i]);
            rightMax = Math.max(rightMax, prices[i]);
        }

        int maxProfit = 0;
        for(int i = 0; i < prices.length - 1; i++){
            maxProfit = Math.max(maxProfit, left[i] + right[i + 1]);
        }
        return maxProfit;
    }

    public static int maxProfitWithAnyTransactions(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit += Math.max(0, prices[i] - prices[i - 1]);
        }
        return maxProfit;
    }

    public static int maxProfitWithKTransactions(int[] prices, int k) {
        if (prices.length == 0) {
            return 0;
        }

        int[][] maxProfit = new int[k + 1][prices.length + 1];
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

    public static int maxProfitWithKTransactionsOptimal(int[] prices, int k) {
        if (prices.length == 0) {
            return 0;
        }

        int[] evenProfit = new int[prices.length];
        int[] oddProfit = new int[prices.length];
        for (int t = 1; t <= k; t++) {
            int[] currentProfit;
            int[] previousProfit;
            int currentMax = Integer.MIN_VALUE;
            if (t % 2 == 1) {
                currentProfit = oddProfit;
                previousProfit = evenProfit;
            } else {
                currentProfit = evenProfit;
                previousProfit = oddProfit;
            }
            for (int i = 1; i < prices.length; i++) {
                currentMax = Math.max(previousProfit[i - 1] - prices[i - 1], currentMax);
                currentProfit[i] = Math.max(currentMax + prices[i], currentProfit[i - 1]);

            }
        }
        return k % 2 == 1 ? oddProfit[prices.length - 1] : evenProfit[prices.length - 1];
    }
}