package recursion.medium;

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
}
