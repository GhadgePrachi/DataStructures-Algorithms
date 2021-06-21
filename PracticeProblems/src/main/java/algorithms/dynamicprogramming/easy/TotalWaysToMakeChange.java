package algorithms.dynamicprogramming.easy;

public class TotalWaysToMakeChange {
    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        int[] waysToMakeChange = new int[n + 1];
        waysToMakeChange[0] = 1;

        for (int i = 0; i < denoms.length; i++) {
            for (int amount = 1; amount <= n; amount++) {
                if (amount - denoms[i] >= 0)
                    waysToMakeChange[amount] += waysToMakeChange[amount - denoms[i]];
            }
        }
        return waysToMakeChange[n];
    }
}
