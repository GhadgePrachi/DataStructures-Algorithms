package datastructures.graph.verytough;

import java.util.HashMap;
import java.util.PriorityQueue;

public class CheapestFlight {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, HashMap<Integer, Integer>> graph = buildGraph(n, flights);
        HashMap<String, Integer> visited = new HashMap<>();
        return search(graph, visited, src, dst, k);
    }

    public HashMap<Integer, HashMap<Integer, Integer>> buildGraph(int n, int[][] flights) {
         HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();
         for (int i = 0; i < n; i++) {
             HashMap<Integer, Integer> edges = new HashMap<>();
             graph.put(i, edges);
         }

         for(int[] flight : flights) {
           int nodeOne = flight[0];
           int nodeTwo = flight[1];
           int weight = flight[2];

           HashMap<Integer, Integer> edges = graph.get(nodeOne);
           edges.put(nodeTwo, weight);
           graph.put(nodeOne, edges);
         }
         return graph;

    }

    public int search(HashMap<Integer, HashMap<Integer, Integer>> graph, HashMap<String, Integer> visited, int src, int dst, int k) {
        PriorityQueue<Integer[]> nextToVisit = new PriorityQueue<>((a, b)-> a[1] - b[1]);
        nextToVisit.offer(new Integer[]{src, 0, 0});

        while (!nextToVisit.isEmpty()) {
            Integer[] edge = nextToVisit.poll();
            int node = edge[0];
            int cost = edge[1];
            int stopsCount = edge[2];

            String key = node + ":" + stopsCount;

            if (cost > visited.getOrDefault(key, Integer.MAX_VALUE) || stopsCount > k + 1) {
                continue;
            }

            if (node == dst) {
                return cost;
            }

            HashMap<Integer, Integer> edges = graph.get(node);
            for (int neighbor : edges.keySet()) {
                int currentCost = edges.get(neighbor) + cost;
                String neighborKey = neighbor + ":" + (stopsCount + 1);
                if (currentCost < visited.getOrDefault(neighborKey, Integer.MAX_VALUE)) {
                    nextToVisit.offer(new Integer[]{neighbor, currentCost, stopsCount + 1});
                    visited.put(neighborKey, currentCost);
                }
            }
        }
        return -1;
    }
}
