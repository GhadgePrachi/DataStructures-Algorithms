package algorithms.recursion.tough;

import java.util.ArrayList;
import java.util.HashMap;

public class StaircaseTraversal {
    public int staircaseTraversal(int height, int maxSteps) {
        HashMap<Integer, Integer> waysToClimbStaircase = new HashMap<>();
        return totalWays(height, maxSteps, waysToClimbStaircase);
    }

    public int totalWays(int height, int maxSteps, HashMap<Integer, Integer> waysToClimbStaircase) {
        if (height < 0)
            return 0;

        if (height == 0)
            return 1;

        if (waysToClimbStaircase.containsKey(height)) {
            return waysToClimbStaircase.get(height);
        }

        int totalWays = 0;
        for (int step = 1; step <= maxSteps; step++) {
            totalWays += totalWays(height - step, maxSteps, waysToClimbStaircase);
        }

        waysToClimbStaircase.put(height, totalWays);
        return totalWays;
    }

    public int staircaseTraversalIterative(int height, int maxSteps) {
        int[] waysToClimbStaircase = new int[height + 1];
        waysToClimbStaircase[0] = 1;
        waysToClimbStaircase[1] = 1;

        for (int currentHeight = 2; currentHeight <= height; currentHeight++) {
            for (int step = 1; step <= maxSteps; step++) {
                if (currentHeight - step >= 0)
                    waysToClimbStaircase[currentHeight] += waysToClimbStaircase[currentHeight - step];
            }
        }
        return waysToClimbStaircase[height];
    }

    public int staircaseTraversalIterativeOptimal(int height, int maxSteps) {
        ArrayList<Integer> waysToClimbStaircase = new ArrayList<>();
        waysToClimbStaircase.add(1);
        int totalWays = 0;
        for (int currentHeight = 1; currentHeight <= height; currentHeight++) {
            int start = currentHeight - maxSteps - 1;
            int end = currentHeight - 1;
            totalWays = totalWays + (waysToClimbStaircase.get(end) + (start >= 0 ? -1 * waysToClimbStaircase.get(start): 0));
            waysToClimbStaircase.add(totalWays);
        }
        return waysToClimbStaircase.get(height);
    }
}
