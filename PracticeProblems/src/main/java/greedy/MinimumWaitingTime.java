package greedy;

import java.util.Arrays;

public class MinimumWaitingTime {
    public int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);
        int totalWaitingTime = 0, currentWaitTime = 0;
        for (int i = 0; i < queries.length - 1; i++) {
            currentWaitTime += queries[i];
            totalWaitingTime += currentWaitTime;
        }
        return totalWaitingTime;
    }
}
