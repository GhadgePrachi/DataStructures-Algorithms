package datastructures.graph.verytough;

import java.util.*;

public class MakeRoutes {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        Graph graph = constructGraph(routes);
        connectEdges(graph, routes);
        return getBusesToDestination(graph, S, T, routes);
    }

    private Graph constructGraph(int[][] routes) {
        int nodesCount = routes.length;
        Graph graph = new Graph();

        for (int i = 0; i < nodesCount; i++) {
            Arrays.sort(routes[i]);
            graph.createNode(i);
        }

        return graph;
    }

    private void connectEdges(Graph graph, int[][] routes) {
        int nodesCount = routes.length;

        for (int i = 0; i < nodesCount; ++i) {
            for (int j = i + 1; j < nodesCount; ++j){

                if(intersect(routes[i], routes[j])) {//if two buses have common stop/s, then connect!
                    graph.getNode(i).addNeighbor(graph.getNode(j));
                    graph.getNode(j).addNeighbor(graph.getNode(i));
                }
            }
        }
    }

    private boolean intersect(int[] A, int[] B) {
        int i = 0, j = 0;

        while (i < A.length && j < B.length) {
            if (A[i] == B[j]) return true;
            else if (A[i] < B[j]) i++;
            else j++;
        }
        return false;
    }

    private int getBusesToDestination(Graph graph, int S, int T, int[][] routes) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> targets = new HashSet<>();
        Queue<BusStop> nextToVisit = new LinkedList<>();
        int nodesCount = routes.length;

        for (int i = 0; i < nodesCount; ++i) {
            if (Arrays.binarySearch(routes[i], S) >= 0) {
                visited.add(i);
                nextToVisit.add(new BusStop(i,0));//begin search with start node(S)
            }
            if (Arrays.binarySearch(routes[i], T) >= 0)
                targets.add(i);
        }

        while (!nextToVisit.isEmpty()) {
            BusStop busStop = nextToVisit.poll();
            int currentBusId = busStop.busId,stopsCount = busStop.stopsFromSource;

            if (targets.contains(currentBusId)) return stopsCount+1;

            for (GraphNode nextBus : graph.getNode(currentBusId).getNeighbors()) {
                if (!visited.contains(nextBus.getId())) {
                    visited.add(nextBus.getId());
                    nextToVisit.offer(new BusStop(nextBus.getId(),stopsCount+1));
                }
            }

        }
        return -1;
    }

    class Graph {
        ArrayList<GraphNode> nodes;
        HashMap<Integer, GraphNode> map;

        public Graph() {
            nodes = new ArrayList<>();
            map = new HashMap<>();
        }

        public GraphNode createNode(int vertexId) {
            if (map.containsKey(vertexId)) {
                return getNode(vertexId);
            }

            GraphNode node = new GraphNode(vertexId);
            nodes.add(node);
            map.put(vertexId, node);
            return node;
        }

        private GraphNode getNode(int vertexId) {
            return map.get(vertexId);
        }

        public ArrayList<GraphNode> getNodes() {
            return nodes;
        }

        public void addEdge(int startId, int endId) {
            GraphNode start = getNode(startId);
            GraphNode end = getNode(endId);
            if (start != null && end != null) {
                start.addNeighbor(end);
                end.addNeighbor(start);
            }
        }
    }

    class GraphNode {
        int vertexId;
        ArrayList<GraphNode> neighbors;
        HashMap<Integer, GraphNode> map;

        public GraphNode(int vertexId) {
            this.vertexId = vertexId;
            neighbors = new ArrayList<>();
            map = new HashMap<>();
        }

        public int getId() {
            return this.vertexId;
        }


        public boolean addNeighbor(GraphNode node) {
            if (map.containsKey(node.getId())) {
                return false;
            }
            neighbors.add(node);
            map.put(node.getId(), node);
            return true;
        }

        public ArrayList<GraphNode> getNeighbors() {
            return neighbors;
        }

        public boolean hasNode(int vertexId) {
            return map.containsKey(vertexId);
        }

    }

    class BusStop{
        int busId;
        int stopsFromSource;

        public BusStop(int busId,int stopsFromSource){
            this.busId = busId;
            this.stopsFromSource = stopsFromSource;
        }
    }
}