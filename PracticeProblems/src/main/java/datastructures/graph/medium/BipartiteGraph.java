package datastructures.graph.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);

        for (int node = 0; node < graph.length; node++) {
            if (colors[node] == -1) {
                if (!searchAndColor(graph, colors, node)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean searchAndColor(int[][] graph, int[] color, int startNode) {
        Queue<Integer> nextToVisit = new LinkedList<>();
        color[startNode] = 0;
        nextToVisit.offer(startNode);

        while (!nextToVisit.isEmpty()) {
            int current = nextToVisit.poll();

            for (int node = 0; node < graph[current].length; node++) {
                if (graph[current][node] == current) { //self-loop
                    return false;
                }
                if (color[graph[current][node]] == color[current]) { //visited before and with same color
                    return false;
                }
                if (color[graph[current][node]] == -1) {  //not visited, visit it and add to the queue
                    color[graph[current][node]] = 1 - color[current];
                    nextToVisit.offer(graph[current][node]);
                }
            }
        }
        return true;
    }
}
