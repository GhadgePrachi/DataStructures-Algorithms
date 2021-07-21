package datastructures.graph.verytough;

import java.util.ArrayList;
import java.util.Arrays;

public class Arbitrage {
    public boolean detectArbitrage(ArrayList<ArrayList<Double>> exchangeRates) {
        ArrayList<ArrayList<Double>> graph = convertToLogMatrix(exchangeRates);

        int vertices = graph.size();
        double[] distancesFromStart = new double[vertices];
        Arrays.fill(distancesFromStart, Double.MAX_VALUE);
        distancesFromStart[0] = 0;

        for (int i = 0; i < vertices; i++) {
            if (!relaxEdges(graph, distancesFromStart)) {
                return false;
            }
        }
        return relaxEdges(graph, distancesFromStart);
    }

    public ArrayList<ArrayList<Double>> convertToLogMatrix(ArrayList<ArrayList<Double>> matrix) {
        ArrayList<ArrayList<Double>> newMatrix = new ArrayList<>();

        for (int i = 0; i < matrix.size(); i++) {
            newMatrix.add(new ArrayList<Double>());
            for (int j = 0; j < matrix.get(i).size(); j++) {
                newMatrix.get(i).add(-Math.log10(matrix.get(i).get(j)));
            }
        }
        return newMatrix;
    }

    public boolean relaxEdges(ArrayList<ArrayList<Double>> graph, double[] distancesFromStart) {
        boolean updated = false;

        for (int i = 0; i < graph.size(); i++) {
            ArrayList<Double> edges = graph.get(i);
            for (int j = 0; j < edges.size(); j++) {
                if (distancesFromStart[j] > distancesFromStart[i] + edges.get(j)) {
                    distancesFromStart[j] = distancesFromStart[i] + edges.get(j);
                    updated = true;
                }
            }
        }
        return updated;
    }
}