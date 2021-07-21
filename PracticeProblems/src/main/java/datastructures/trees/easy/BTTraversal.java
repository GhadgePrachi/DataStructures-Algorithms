package datastructures.trees.easy;

import java.util.*;

public class BTTraversal {
    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;
        public BinaryTree parent;

        public BinaryTree(int value) {
            this.value = value;
        }

        public BinaryTree(int value, BinaryTree parent) {
            this.value = value;
            this.parent = parent;
        }

        /** DEPTH FIRST SEARCH **/
        /** Recursive Traversals **/
        /** PreOrder Traversal **/
        public static List<Integer> preOrderTraverse(BinaryTree tree, List<Integer> array) {
            if (tree != null) {
                array.add(tree.value);
                preOrderTraverse(tree.left, array);
                preOrderTraverse(tree.right, array);
            }
            return array;
        }

        /** InOrder Traversal **/
        public static List<Integer> inOrderTraverse(BinaryTree tree, List<Integer> array) {
            if (tree != null) {
                inOrderTraverse(tree.left, array);
                array.add(tree.value);
                inOrderTraverse(tree.right, array);
            }
            return array;
        }

        /** PostOrder Traversal **/
        public static List<Integer> postOrderTraverse(BinaryTree tree, List<Integer> array) {
            if (tree != null) {
                postOrderTraverse(tree.left, array);
                postOrderTraverse(tree.right, array);
                array.add(tree.value);
            }
            return array;
        }

        /** Iterative Traversals **/
        /** PreOrder Traversal **/
        public List<Integer> preOrderIterative(BinaryTree tree) {
            if (tree == null) {
                return new ArrayList<>();
            }

            Stack<BinaryTree> nextToVisit = new Stack<>();
            LinkedList<Integer> list = new LinkedList<>();
            while (!nextToVisit.isEmpty() || tree != null) {
                if (tree != null) {
                    list.add(tree.value);
                    nextToVisit.push(tree);
                    tree = tree.left;
                } else {
                    tree = nextToVisit.pop();
                    tree = tree.right;
                }
            }
            return list;
        }

        /** InOrder Traversal **/
        public List<Integer> inOrderIterative(BinaryTree tree) {
            if (tree == null) {
                return new ArrayList<>();
            }

            Stack<BinaryTree> nextToVisit = new Stack<>();
            LinkedList<Integer> list = new LinkedList<>();
            while (!nextToVisit.isEmpty() || tree != null) {
                while (tree != null) {
                    nextToVisit.push(tree);
                    tree = tree.left;
                }
                tree = nextToVisit.pop();
                list.add(tree.value);
                tree = tree.right;
            }
            return list;
        }

        /** PostOrder Traversal **/
        public List<Integer> postOrderIterative(BinaryTree tree) {
            if (tree == null) {
                return new ArrayList<>();
            }

            Stack<BinaryTree> nextToVisit = new Stack<BinaryTree>();
            LinkedList<Integer> list = new LinkedList<>();
            while (!nextToVisit.isEmpty() || tree != null) {
                if (tree != null) {
                    nextToVisit.push(tree);
                    list.addFirst(tree.value);
                    tree = tree.right;
                } else {
                    tree = nextToVisit.pop();
                    tree = tree.left;
                }
            }
            return list;
        }

        /** BREADTH FIRST SEARCH **/
        /** ZizZag Traversal **/
        public List<List<Integer>> zigZagTraversal(BinaryTree tree) {
            if (tree == null) {
                return null;
            }

            int level = 0;
            List<List<Integer>> list = new ArrayList<>();
            Queue<BinaryTree> nextToVisit = new LinkedList<>();
            nextToVisit.add(tree);

            while (!nextToVisit.isEmpty()) {
                List<Integer> sublist = new ArrayList<Integer>();
                int levelSize = nextToVisit.size();

                for (int i = 0; i < levelSize; i++) {
                    BinaryTree current = nextToVisit.poll();
                    if (level % 2 == 0) {
                        sublist.add(current.value);
                    } else {
                        sublist.add(0, current.value);
                    }

                    if (current.left != null) {
                        nextToVisit.add(current.left);
                    }
                    if (current.right != null) {
                        nextToVisit.add(current.right);
                    }

                }
                list.add(sublist);
                level++;
            }
            return list;
        }
    }
}