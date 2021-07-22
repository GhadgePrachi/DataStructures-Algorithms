package datastructures.graph.tough;

import java.util.Arrays;

public class ConnectedGraph {
    public boolean twoEdgeConnectedGraph(int[][] graph) {
        int[] times = new int[graph.length];
        Arrays.fill(times, -1);

        if (search(0, -1, 0, times, graph) == -1) { //search for a bridge
            return false;
        }
        return isConnected(times);
    }

    public int search(int current, int parent, int currentTime, int[] times, int[][] graph) {
        times[current] = currentTime;
        int minimalTime = currentTime;

        for (int neighbor : graph[current]) {
            if (times[neighbor] == -1) { //not visited
                int nextTime = search(neighbor, current, currentTime + 1, times, graph);
                minimalTime = Math.min(minimalTime, nextTime);
            } else if (neighbor != parent) { //visited
                minimalTime = Math.min(minimalTime, times[neighbor]);
            }
        }

        if (minimalTime == currentTime && parent != -1) { //bridge
            return -1;
        } else {
            return minimalTime;
        }
    }

    public boolean isConnected(int[] times) {
        for (int time : times) {
            if (time == -1) {
                return false;
            }
        }
        return true;
    }
}
