package datastructures.graph.verytough;

import java.util.*;

public class MergeAccounts {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new LinkedList<>();
        if (accounts == null || accounts.size() == 0) {
            return res;
        }

        Graph graph = buildGraph(accounts);
        Set<String> visited = new HashSet<>();
        List<String> list;
        for (GraphNode node : graph.getNodes()) {
            list = new LinkedList<>();
            if (!visited.contains(node.emailId)) {
                union(graph,node, visited,list);
                Collections.sort(list);
                list.add(0, node.userName);
                res.add(list);
            }
        }
        return res;
    }

    public Graph buildGraph(List<List<String>> accounts){
        Graph graph = new Graph();

        for (List<String> account : accounts) {
            String userName = account.get(0);
            if(account.size()==2) graph.getOrCreateNode(account.get(account.size()-1),userName); //For size = 2

            for (int i = 2; i < account.size(); i++) {
                graph.addEdge(account.get(i),account.get(i-1),userName); //For size > 2
            }
        }
        return graph;
    }

    public void union(Graph graph, GraphNode node, Set<String> visited, List<String> list) {
        list.add(node.emailId);
        visited.add(node.emailId);

        for (GraphNode neighbor : node.getNeighbors()) {
            if (!visited.contains(neighbor.emailId)) {
                union(graph, neighbor, visited, list);
            }
        }
    }

    public class Graph {
        private ArrayList<GraphNode> nodes;
        private HashMap<String, GraphNode> map;

        public Graph() {
            map = new HashMap<>();
            nodes = new ArrayList<>();
        }

        public boolean hasNode(String emailId) {
            return map.containsKey(emailId);
        }

        public GraphNode getOrCreateNode(String emailId, String userName) {
            if (map.containsKey(emailId)) {
                return getNode(emailId);
            }

            GraphNode node = new GraphNode(emailId, userName);
            nodes.add(node);
            map.put(emailId, node);
            return node;
        }

        private GraphNode getNode(String name) {
            return map.get(name);
        }

        public ArrayList<GraphNode> getNodes() {
            return nodes;
        }

        public void addEdge(String startName, String endName, String userName) {
            GraphNode start = getOrCreateNode(startName,userName);
            GraphNode end = getOrCreateNode(endName,userName);

            if (start != null && end != null) {
                start.addNeighbor(end);
                end.addNeighbor(start);
            }
        }
    }

    public class GraphNode {
        private ArrayList<GraphNode> neighbors;
        private HashMap<String, GraphNode> map;
        private String emailId="";
        private String userName="";

        public GraphNode(String emailId,String userName) {
            this.emailId = emailId;
            this.userName = userName;
            neighbors = new ArrayList<>();
            map = new HashMap<>();
        }

        public String getEmailId() {
            return emailId;
        }

        public String getUserName() {
            return userName;
        }

        public boolean addNeighbor(GraphNode node) {
            if (map.containsKey(node.getEmailId())) {
                return false;
            }
            neighbors.add(node);
            map.put(node.getEmailId(), node);
            return true;
        }

        public ArrayList<GraphNode> getNeighbors() {
            return neighbors;
        }
    }
}