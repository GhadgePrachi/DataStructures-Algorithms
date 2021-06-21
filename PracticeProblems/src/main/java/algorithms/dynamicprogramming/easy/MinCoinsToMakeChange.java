package algorithms.dynamicprogramming.easy;

import java.util.Arrays;

public class MinCoinsToMakeChange {
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        int[] minCoins = new int[n + 1];
        Arrays.fill(minCoins, Integer.MAX_VALUE);
        minCoins[0] = 0;
        int localMin = 0;
        for (int i = 0; i < denoms.length; i++) {
            for (int amount = 1; amount <= n; amount++) {
                if (amount - denoms[i] >= 0) {
                    if (minCoins[amount - denoms[i]] == Integer.MAX_VALUE) {
                        localMin = minCoins[amount - denoms[i]];
                    } else {
                        localMin = minCoins[amount - denoms[i]] + 1;
                    }
                    minCoins[amount] = Math.min(minCoins[amount], localMin);
                }
            }
        }
        return minCoins[n] == Integer.MAX_VALUE ? -1 : minCoins[n];
    }
}
