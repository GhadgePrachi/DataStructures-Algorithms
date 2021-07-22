package datastructures.graph.verytough;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BidirectionalSearch {
    public class Graph {
        public LinkedList<Graph_VertexNode> findPath(HashMap<Integer,Graph_VertexNode> persons, Graph_VertexNode p, Graph_VertexNode q){
            Graph_PathGraph source = new Graph_PathGraph(p);
            Graph_PathGraph destination = new Graph_PathGraph(q);
            while (!source.isFinished() && !destination.isFinished()) {
                Graph_VertexNode collision;
                collision = breadthFirstSearchToCollidingNode(persons,source,destination);
                if (collision!=null) {
                    return mergePaths(source,destination,collision.vertexId);
                }

                collision = breadthFirstSearchToCollidingNode(persons,destination,source);
                if (collision!=null) {
                    return mergePaths(source,destination,collision.vertexId);
                }
            }
            return null;
        }

        public Graph_VertexNode breadthFirstSearchToCollidingNode(HashMap<Integer,Graph_VertexNode> people, Graph_PathGraph p, Graph_PathGraph q){
            int count = p.nextToVisit.size();
            for (int i = 0; i < count; i++) {
                Graph_PathNode pathNode = p.nextToVisit.poll();
                int personId = pathNode.node.vertexId;
                if (q.visited.containsKey(personId)) {
                    return pathNode.node;
                }

                Graph_VertexNode person = pathNode.node;
                ArrayList<Integer> friends = person.neighbors;
                for (int friendId : friends) {
                    if (!p.visited.containsKey(friendId)) {
                        Graph_VertexNode friend = people.get(friendId);
                        Graph_PathNode next = new Graph_PathNode(friend, pathNode);
                        p.visited.put(friendId, next);
                        p.nextToVisit.add(next);
                    }
                }
            }
            return null;
        }

        public LinkedList<Graph_VertexNode> mergePaths(Graph_PathGraph p, Graph_PathGraph q,int collision){
            Graph_PathNode collision01 = p.visited.get(collision); // start<-n1<-n2<-n3...<-collision01
            Graph_PathNode collision02 = q.visited.get(collision); // end<-n1<-n2<-n3...<-collision02
            LinkedList<Graph_VertexNode> pathOne = collision01.collapse(false); // collision01 is end node in the path : start<-n1<-n2<-n3...<-collision01
            LinkedList<Graph_VertexNode> pathTwo = collision02.collapse(true); //  collision02 is start node in the path : end<-n1<-n2<-n3...<-collision02
            pathTwo.removeFirst(); // colliding node added twice
            pathOne.addAll(pathTwo); // add pathTwo at end of pathOne
            return pathOne;
        }
    }

    public class Graph_VertexNode {
        int vertexId;
        ArrayList<Integer> neighbors;
    }

    public class Graph_Edge {
        Graph_VertexNode p,q;
        int edgeDistance;
    }

    public class Graph_PathNode {
        Graph_VertexNode node;
        Graph_PathNode previous;

        public Graph_PathNode(Graph_VertexNode node, Graph_PathNode previous) {
            this.node = node;
            this.previous = previous;
        }

        public LinkedList<Graph_VertexNode> collapse(boolean isStartNode) {
            LinkedList<Graph_VertexNode> path = new LinkedList<>();
            Graph_PathNode node = this;
            while (node != null) {
                if (isStartNode) {
                    path.addLast(node.node);
                } else {
                    path.addFirst(node.node);
                }
                node = node.previous;
            }
            return path;
        }
    }

    public class Graph_PathGraph {
        Graph_VertexNode root;
        Queue<Graph_PathNode> nextToVisit = new LinkedList<>();
        HashMap<Integer, Graph_PathNode> visited = new HashMap<>();

        public Graph_PathGraph(Graph_VertexNode root) {
            Graph_PathNode pathNode = new Graph_PathNode(root, null);
            nextToVisit.add(pathNode);
            visited.put(root.vertexId, pathNode);
        }

        public boolean isFinished() {
            return nextToVisit.isEmpty();
        }
    }
}