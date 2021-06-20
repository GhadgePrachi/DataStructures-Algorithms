package algorithms.dynamicprogramming.medium;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {
    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
        int[][] knapsack = new int[items.length + 1][capacity + 1];
        for (int i = 1; i <= items.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (j - items[i - 1][1] >= 0) {
                    knapsack[i][j] = Math.max(knapsack[i - 1][j], knapsack[i - 1][j - items[i - 1][1]] + items[i - 1][0]);
                } else {
                    knapsack[i][j] = knapsack[i-1][j];
                }
            }
        }
        return getSequence(knapsack, items);
    }

    public static List<List<Integer>> getSequence(int[][] knapsack, int[][] items) {
        List<List<Integer>> sequence = new ArrayList<>();
        List<Integer> value = new ArrayList<>();
        value.add(knapsack[knapsack.length - 1][knapsack[0].length - 1]);
        List<Integer> indices = new ArrayList<>();
        sequence.add(value);
        sequence.add(indices);

        int i = knapsack.length - 1;
        int j = knapsack[0].length - 1;
        while (i > 0) {
            if (knapsack[i][j] == knapsack[i - 1][j]) {
                i -= 1;
            } else {
                sequence.get(1).add(0,i - 1);
                j = j - items[i - 1][1];
                i -= 1;
            }

            if (j == 0)
                break;
        }
        return sequence;
    }
}
