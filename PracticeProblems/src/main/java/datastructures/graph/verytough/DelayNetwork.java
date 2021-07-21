package datastructures.graph.verytough;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class DelayNetwork {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, HashMap<Integer, Integer>> graph = buildGraph(n, times);

        int[] visited = new int[n + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        search(graph, visited, k);

        int delay = Integer.MIN_VALUE;
        for (int i = 1; i < visited.length; i++) {
            if (i == k) {
                continue;
            }
            int time = visited[i];
            if (time == Integer.MAX_VALUE) {
                return -1;
            } else {
                delay = Math.max(delay, time);
            }
        }
        return delay;
    }

    public HashMap<Integer, HashMap<Integer, Integer>> buildGraph(int n, int[][] times) {
         HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();
         for (int i = 1; i <= n; i++) {
             HashMap<Integer, Integer> edges = new HashMap<>();
             graph.put(i, edges);
         }

         for(int[] time : times) {
           int nodeOne = time[0];
           int nodeTwo = time[1];
           int weight = time[2];

           HashMap<Integer, Integer> edges = graph.get(nodeOne);
           edges.put(nodeTwo, weight);
           graph.put(nodeOne, edges);
         }
         return graph;

    }

    public void search(HashMap<Integer, HashMap<Integer, Integer>> graph, int[] visited, int k) {
        PriorityQueue<Integer[]> nextToVisit = new PriorityQueue<>((a, b)-> a[1] - b[1]);
        nextToVisit.offer(new Integer[]{k, 0});

        while (!nextToVisit.isEmpty()) {
            Integer[] edge = nextToVisit.poll();
            int node = edge[0];
            int time = edge[1];
            if (time > visited[node]) {
                continue;
            }

            HashMap<Integer, Integer> edges = graph.get(node);
            for (int neighbor : edges.keySet()) {
                int currentTime = edges.get(neighbor) + time;
                if (currentTime < visited[neighbor]) {
                    nextToVisit.offer(new Integer[]{neighbor, currentTime});
                    visited[neighbor] = currentTime;
                }
            }
        }
    }
}