package datastructures.graph.verytough;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class EvaluateDivision {
    public double[] calculateEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> graph = buildGraph(equations, values);
        double[] results = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String nodeOne = query.get(0);
            String nodeTwo = query.get(1);

            HashSet<String> visited = new HashSet<>();
            double result = calculate(nodeOne, nodeTwo, graph, visited);
            results[i] = result;
        }
        return results;

    }

    public HashMap<String, HashMap<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String node1 = equation.get(0);
            String node2 = equation.get(1);
            double value = values[i];

            HashMap<String, Double> edges;
            if (graph.containsKey(node1)) {
                edges = graph.get(node1);
            } else {
                edges = new HashMap<>();
            }
            edges.put(node2, value);
            graph.put(node1, edges);


            if (graph.containsKey(node2)) {
                edges = graph.get(node2);
            } else {
                edges = new HashMap<>();
            }
            edges.put(node1, 1 / value);
            graph.put(node2, edges);
        }

        return graph;
    }

    public double calculate(String nodeOne, String nodeTwo, HashMap<String, HashMap<String, Double>> graph, HashSet<String> visited) {
        if (visited.contains(nodeOne) || !graph.containsKey(nodeOne)) {
            return -1.0d;
        }

        if (nodeOne.equals(nodeTwo)) {
            return 1.0d;
        }

        visited.add(nodeOne);
        double value = -1.0d;
        HashMap<String, Double> edges = graph.get(nodeOne);
        for (String neighbor : edges.keySet()) {
            value = calculate(neighbor, nodeTwo, graph, visited);
            if (value != -1.0d) {
                value = value * edges.get(neighbor);
                break;
            }
        }
        return value;
    }
}
