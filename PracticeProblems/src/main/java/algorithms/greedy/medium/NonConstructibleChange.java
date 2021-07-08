package algorithms.greedy.medium;

import java.util.Arrays;

public class NonConstructibleChange {
    public int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);

        int currentChange = 0;
        for (int coin : coins) {
            if (currentChange + 1 < coin) {
                return currentChange + 1;
            } else {
                currentChange += coin;
            }
        }
        return currentChange + 1;
    }
}
