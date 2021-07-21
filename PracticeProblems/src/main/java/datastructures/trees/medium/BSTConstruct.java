package datastructures.trees.medium;

import java.util.ArrayList;
import java.util.List;

public class BSTConstruct {
    /** Minimum Height Tree from An Array **/
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static BST minHeightBST(List<Integer> array) {
        return minHeightBST(array, 0, array.size() - 1);
    }

    public static BST minHeightBST(List<Integer> array, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start)/2;
        BST tree = new BST(array.get(mid));
        tree.left = minHeightBST(array, start, mid - 1);
        tree.right = minHeightBST(array, mid + 1, end);
        return tree;
    }

    /** Special BST **/
    static class SpecialBST {
        int value;
        int index;
        int leftSubtreeSize;
        SpecialBST left;
        SpecialBST right;

        public SpecialBST(int value) {
            this.value = value;
            this.leftSubtreeSize = 0;
            this.left = null;
            this.right = null;
        }

        public void insert(int value, int index, List<Integer> rightSmallerCounts) {
            insert(value, index, rightSmallerCounts, 0);
        }

        public void insert(int value, int index, List<Integer> rightSmallerCounts, int smallerCount) {
            if (value < this.value) {
                this.leftSubtreeSize++;
                if (this.left == null) {
                    left = new SpecialBST(value);
                    rightSmallerCounts.set(index, smallerCount);
                } else {
                    left.insert(value, index, rightSmallerCounts, smallerCount);
                }
            } else {
                if (this.value == value) {
                    smallerCount += leftSubtreeSize; //exclude the root
                } else if (this.value < value) {
                    smallerCount += leftSubtreeSize + 1; //include the root
                }

                if (this.right == null) {
                    right = new SpecialBST(value);
                    rightSmallerCounts.set(index, smallerCount);
                } else {
                    right.insert(value, index, rightSmallerCounts, smallerCount);
                }
            }
        }
    }

    public static List<Integer> rightSmallerThan(List<Integer> array) {
        if (array.size() == 0) {
            return new ArrayList<Integer>();
        }

        List<Integer> rightSmallerCounts = new ArrayList<Integer>(array);
        rightSmallerCounts.set(array.size() - 1, 0);
        SpecialBST bst = new SpecialBST(array.get(array.size() - 1));
        for (int i = array.size() - 2; i >= 0; i--) {
            bst.insert(array.get(i), i, rightSmallerCounts, 0);
        }
        return rightSmallerCounts;
    }

    /** Get Rank BST **/
    static class RankTree {
        private static RankNode root = null;

        public void insert(int number) {
            if (root == null) {
                root = new RankNode(number);
            } else {
                root.insert(number);
            }
        }

        public static int getRankOfNumber(int number) {
            return root.getRank(number);
        }
    }

    static class RankNode {
        public int leftSubtreeSize = 0;
        public RankNode left;
        public RankNode right;
        public int value = 0;

        public RankNode(int value) {
            this.value = value;
        }

        public void insert(int value) {
            if (this.value >= value) {
                this.leftSubtreeSize++;
                if (left != null) {
                    left.insert(value);
                } else {
                    left = new RankNode(value);
                }
            } else {
                if (right != null) {
                    right.insert(value);
                } else {
                    right = new RankNode(value);
                }
            }
        }

        public int getRank(int value) {
            if (this.value == value) {
                return leftSubtreeSize;
            } else if (value < this.value) {
                if (left == null) {
                    return -1;
                } else {
                    return left.getRank(value);
                }
            } else {
                if (right == null) {
                    return -1;
                } else {
                    return right.getRank(value) + leftSubtreeSize + 1 ;
                }
            }
        }
    }

    /** Random Node **/
    class RandomNode {
        public int value;
        public RandomNode left;
        public RandomNode right;
        private int size = 0;

        public RandomNode(int value) {
            this.value = value;
            size = 1;
        }

        public void insertInOrder(int value) {
            if (this.value >= value) {
                if (left == null) {
                    left = new RandomNode(value);
                } else {
                    left.insertInOrder(value);
                }
            } else {
                if (right == null) {
                    right = new RandomNode(value);
                } else {
                    right.insertInOrder(value);
                }
            }
            size++;
        }

        public int size() {
            return size;
        }

        public RandomNode getIthNode(int i) {
            int leftSubTreeSize = 0;
            if (left != null) {
                leftSubTreeSize = left.size();
            }

            if (i < leftSubTreeSize) {
                return left.getIthNode(i);
            } else if (i == leftSubTreeSize) {
                return this;
            } else {
                return right.getIthNode(i - (leftSubTreeSize + 1));
            }
        }
    }

    /** Serialize-Deserialize BST **/
    int index = 0;
    private static final String splitter = ",";
    private static final String delimiter = "#";

    public  String serialize(BST tree) {
        StringBuilder sb = new StringBuilder();
        buildString(tree , sb);
        return sb.toString();
    }

    private  void buildString(BST tree, StringBuilder sb) {
        if (tree == null) {
            sb.append(delimiter).append(splitter);
            return;
        } else {
            sb.append(tree.value).append(splitter); // Add root
            buildString(tree.left, sb);  // Add left
            buildString(tree.right, sb); // Add right
        }
    }

    public BST deSerialize(String data){
        String[] input = data.split(splitter);
        return buildTree(input , Integer.MAX_VALUE , Integer.MIN_VALUE);
    }

    private  BST buildTree(String[] input , int min , int max) {
        if (index >= input.length || input[index].equals(delimiter) || Integer.valueOf(input[index]) >= max || Integer.valueOf(input[index]) <= min) {
            index++;
            return null;
        } else {
            BST tree = new BST(Integer.valueOf(input[index++]));
            tree.left = buildTree(input, min, Integer.valueOf(tree.value));
            tree.right = buildTree(input, Integer.valueOf(tree.value), max);
            return tree;
        }
    }
}