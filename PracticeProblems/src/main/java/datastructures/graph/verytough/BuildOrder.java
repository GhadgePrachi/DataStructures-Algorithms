package datastructures.graph.verytough;

import java.util.ArrayList;
import java.util.HashMap;

public class BuildOrder {
     public class Graph {
        private ArrayList<Project> nodes = new ArrayList<>();
        private HashMap<String, Project> map = new HashMap<>();

        public Project getOrCreateNode(String name) {
            if (!map.containsKey(name)) {
                Project node = new Project(name);
                nodes.add(node);
                map.put(name, node);
            }

            return map.get(name);
        }

        public void addEdge(String startName, String endName) {
            Project start = getOrCreateNode(startName);
            Project end = getOrCreateNode(endName);
            start.addNeighbor(end);
        }

        public ArrayList<Project> getNodes() {
            return nodes;
        }
    }

    public class Project {
        private ArrayList<Project> neighbors = new ArrayList<Project>();
        private HashMap<String, Project> map = new HashMap<String, Project>();
        private String name;
        private int dependencies = 0;

        public Project(String n) {
            name = n;
        }

        public String getName() {
            return name;
        }

        public void addNeighbor(Project node) {
            if (!map.containsKey(node.getName())) {
                neighbors.add(node);
                map.put(node.getName(), node);
                node.incrementDependencies();
            }
        }

        public void incrementDependencies() {
            dependencies++;
        }

        public ArrayList<Project> getNeighbors() {
            return neighbors;
        }

        public void decrementDependencies() {
            dependencies--;
        }

        public int getNumberDependencies() {
            return dependencies;
        }
    }

    public  Project[] findBuildOrder(String[] projects, String[][] dependencies) {
        if (projects == null || dependencies == null){
            return null;
        }
        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
    }

    public  Graph buildGraph(String[] projects, String[][] dependencies) {
        Graph graph = new Graph();
        for (String project : projects) {
            graph.getOrCreateNode(project);
        }

        for (String[] dependency : dependencies) {
            String first = dependency[0];
            String second = dependency[1];
            graph.addEdge(first, second);
        }

        return graph;
    }

    public  Project[] orderProjects(ArrayList<Project> projects) {
        Project[] order = new Project[projects.size()];

        /* Add “roots” to the build order first.*/
        int endOfList = addNonDependent(order, projects, 0);

        int toBeProcessed = 0;
        while (toBeProcessed < order.length) {
            Project current = order[toBeProcessed];

            /* We have a circular dependency since there are no remaining
             * projects with zero dependencies. */
            if (current == null) {
                return null;
            }

            /* Remove myself as a dependency. */
            ArrayList<Project> children = current.getNeighbors();
            for (Project child : children) {
                child.decrementDependencies();
            }

            /* Add neighbors that have no one depending on them. */
            endOfList = addNonDependent(order, children, endOfList);

            toBeProcessed++;
        }

        return order;
    }

    public static int addNonDependent(Project[] order, ArrayList<Project> projects, int offset) {
        for (Project project : projects) {
            if (project.getNumberDependencies() == 0) {
                order[offset] = project;
                offset++;
            }
        }
        return offset;
    }
}
