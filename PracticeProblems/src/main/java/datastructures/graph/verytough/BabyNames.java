package datastructures.graph.verytough;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BabyNames {
    public class Graph {
        private ArrayList<GraphNode> nodes;
        private HashMap<String, GraphNode> map;

        public Graph() {
            map = new HashMap<String, GraphNode>();
            nodes = new ArrayList<GraphNode>();
        }

        public boolean hasNode(String name) {
            return map.containsKey(name);
        }

        public GraphNode createNode(String name, int freq) {
            if (map.containsKey(name)) {
                return getNode(name);
            }

            GraphNode node = new GraphNode(name, freq);
            nodes.add(node);
            map.put(name, node);
            return node;
        }

        private GraphNode getNode(String name) {
            return map.get(name);
        }

        public ArrayList<GraphNode> getNodes() {
            return nodes;
        }

        public void addEdge(String startName, String endName) {
            GraphNode start = getNode(startName);
            GraphNode end = getNode(endName);
            if (start != null && end != null) {
                start.addNeighbor(end);
                end.addNeighbor(start);
            }
        }
    }

    public class GraphNode {
        private ArrayList<GraphNode> neighbors;
        private HashMap<String, GraphNode> map;
        private String name;
        private int frequency;
        private boolean visited = false;

        public GraphNode(String nm, int freq) {
            name = nm;
            frequency = freq;
            neighbors = new ArrayList<GraphNode>();
            map = new HashMap<String, GraphNode>();
        }

        public String getName() {
            return name;
        }

        public int getFrequency() {
            return frequency;
        }

        public boolean addNeighbor(GraphNode node) {
            if (map.containsKey(node.getName())) {
                return false;
            }
            neighbors.add(node);
            map.put(node.getName(), node);
            return true;
        }

        public ArrayList<GraphNode> getNeighbors() {
            return neighbors;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setIsVisited(boolean v) {
            visited = v;
        }
    }

    public  HashMap<String, Integer> trulyMostPopular(HashMap<String, Integer> names, String[][] synonyms) {
        if (names == null || synonyms == null || names.size() == 0 || synonyms.length == 0){
            return null;
        }

        Graph graph = constructGraph(names);
        connectEdges(graph, synonyms);
        HashMap<String, Integer> rootNames = getTrueFrequencies(graph);
        return rootNames;
    }

    public  Graph constructGraph(HashMap<String, Integer> names) {
        Graph graph = new Graph();
        for (Map.Entry<String, Integer> entry : names.entrySet()) {
            String name = entry.getKey();
            int frequency = entry.getValue();
            graph.createNode(name, frequency);
        }
        return graph;
    }

    public  void connectEdges(Graph graph, String[][] synonyms) {
        for (String[] entry : synonyms) {
            String name1 = entry[0];
            String name2 = entry[1];
            graph.addEdge(name1,  name2);
        }
    }

    public HashMap<String, Integer> getTrueFrequencies(Graph graph) {
        HashMap<String, Integer> rootNames = new HashMap<String, Integer>();
        for (GraphNode node : graph.getNodes()) {
            if (!node.isVisited()) {
                int frequency = getComponentFrequency(node);
                String name = node.getName();
                rootNames.put(name, frequency);
            }
        }
        return rootNames;
    }

    public int getComponentFrequency(GraphNode node) {
        if (node.isVisited()) {
            return 0;
        }
        node.setIsVisited(true);
        int sum = node.getFrequency();
        for (GraphNode child : node.getNeighbors()) {
            sum += getComponentFrequency(child);
        }
        return sum;
    }
}