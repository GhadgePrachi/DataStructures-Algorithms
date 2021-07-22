package datastructures.graph.verytough;

import java.util.*;

public class Flights {
    public static int airportConnections(List<String> airports, List<List<String>> routes, String startingAirport) {
        HashMap<String, Airport> airportGraph = createGraph(airports, routes);
        List<Airport> unreachableAirports = getUnreachableAirports(airportGraph, airports, startingAirport);
        markUnreachableAirports(airportGraph, unreachableAirports);
        return getMinRequiredConnections(airportGraph, unreachableAirports);
    }

    public static HashMap<String, Airport> createGraph(List<String> airports, List<List<String>> routes) {
        HashMap<String, Airport> airportGraph = new HashMap<>();
        for (String airport : airports)
            airportGraph.put(airport, new Airport(airport));

        for (List<String> route : routes) {
            String airportOne = route.get(0);
            String airportTwo = route.get(1);
            airportGraph.get(airportOne).neighboringAirports.add(airportTwo);
        }
        return airportGraph;
    }

    public static List<Airport> getUnreachableAirports(HashMap<String, Airport> airportGraph, List<String> airports, String startingAirport) {
        Set<String> visited = new HashSet<>();
        searchAirports(airportGraph, startingAirport, visited);

        List<Airport> unreachableAirports = new ArrayList<>();
        for (String airport : airports) {
            if (visited.contains(airport)) {
                continue;
            }
            Airport currentAirport = airportGraph.get(airport);
            currentAirport.isReachable = false;
            unreachableAirports.add(currentAirport);
        }
        return unreachableAirports;
    }

    public static void searchAirports(HashMap<String, Airport> airportGraph, String airport, Set<String> visited) {
        if (visited.contains(airport)) {
            return;
        }

        visited.add(airport);
        List<String> neighbors = airportGraph.get(airport).neighboringAirports;
        for (String neighbor : neighbors) {
            searchAirports(airportGraph, neighbor, visited);
        }
    }

    public static void markUnreachableAirports(HashMap<String, Airport> airportGraph, List<Airport> unreachableAirportsFromStart) {
        for (Airport currentAirport : unreachableAirportsFromStart) {
            String airport = currentAirport.airport;
            List<String> unreachableAirports = new ArrayList<>();
            Set<String> visited = new HashSet<>();
            searchUnreachableAirports(airportGraph, airport, unreachableAirports, visited);
            currentAirport.unreachableAirports = unreachableAirports;
        }
    }

    public static void searchUnreachableAirports(HashMap<String, Airport> airportGraph, String airport, List<String> unreachableAirports, Set<String> visited) {
        if (airportGraph.get(airport).isReachable) {
            return;
        }

        if (visited.contains(airport)) {
            return;
        }

        visited.add(airport);
        unreachableAirports.add(airport);
        List<String> neighbors = airportGraph.get(airport).neighboringAirports;
        for (String neighbor : neighbors) {
            searchUnreachableAirports(airportGraph, neighbor, unreachableAirports, visited);
        }
    }

    public static int getMinRequiredConnections(HashMap<String, Airport> airportGraph, List<Airport> unreachableAirports) {
        int minRequiredConnection = 0;

        Collections.sort(unreachableAirports, (a,b)->b.unreachableAirports.size() - a.unreachableAirports.size());

        for (Airport currentAirport : unreachableAirports) {
            if (currentAirport.isReachable) {
                continue;
            } else {
                minRequiredConnection += 1;
            }

            for (String neighborAirport : currentAirport.unreachableAirports) {
                airportGraph.get(neighborAirport).isReachable = true;
            }
        }
        return minRequiredConnection;
    }

    static class Airport {
        String airport;
        List<String> neighboringAirports;
        List<String> unreachableAirports;
        boolean isReachable;

        public Airport(String airport) {
            this.airport = airport;
            this.neighboringAirports = new ArrayList<>();
            this.unreachableAirports = new ArrayList<>();
            isReachable = true;
        }
    }
}