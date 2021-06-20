package algorithms.dynamicprogramming.easy;

import java.util.HashMap;

public class GraphTraversal {
    public int numberOfWaysToTraverseGraph(int width, int height) {
        int[][] totalWays = new int[width + 1][height + 1];
        for (int i = 1; i <= width; i++) {
            for (int j = 1; j <= height; j++) {
                if (i == 1 || j == 1) {
                    totalWays[i][j] = 1;
                } else {
                    totalWays[i][j] = totalWays[i-1][j] + totalWays[i][j-1];
                }
            }
        }
        return totalWays[width][height];
    }
}
