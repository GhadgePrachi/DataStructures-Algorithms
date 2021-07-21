package datastructures.graph.tough;

public class CycledGraph {
    public boolean cycleInGraph(int[][] graph) {
        int nodesCount = graph.length;
        boolean[] visited = new boolean[nodesCount];

        for (int node = 0; node < graph.length; node++) {
            if (hasCycle(node, -1, graph, visited)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasCycle(int current, int parent, int[][] graph, boolean[] visited) {
        if (parent == current || visited[current]) {
            return true;
        }

        visited[current] = true;
        for (int neighbor : graph[current]) {
            if (hasCycle(neighbor, current, graph, visited)) {
                return true;
            }

        }
        visited[current] = false;
        return false;
    }
}
