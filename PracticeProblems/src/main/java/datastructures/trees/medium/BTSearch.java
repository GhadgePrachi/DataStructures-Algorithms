package datastructures.trees.medium;

import java.util.*;

public class BTSearch {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    /** Successor Node **/
    public BinaryTree findSuccessor(BinaryTree tree) {
        if (tree.right != null) {
            return getLeftMostChild(tree.right);
        }
        return getRightMostParent(tree);
    }

    public static BinaryTree getLeftMostChild(BinaryTree tree) {
        while (tree.left != null) {
            tree = tree.left;
        }
        return tree;
    }

    public static BinaryTree getRightMostParent(BinaryTree tree) {
        while (tree.parent != null && tree.parent.right == tree) {
            tree = tree.parent;
        }
        return tree.parent;
    }

    /** Lowest Common Ancestor **/
    public BinaryTree closestCommonAncestor(BinaryTree tree, BinaryTree nodeOne, BinaryTree nodeTwo) {
        BinaryTree lowestCommonAncestor = null;
        Stack<BinaryTree> pathOne = getPath(tree,nodeOne);
        Stack<BinaryTree> pathTwo = getPath(tree,nodeTwo);

        while (!pathOne.isEmpty() && !pathTwo.isEmpty()) {
            BinaryTree elementOne = pathOne.pop();
            BinaryTree elementTwo = pathTwo.pop();
            if (elementOne == elementTwo) {
                lowestCommonAncestor = elementOne;
            } else {
                break;
            }
        }
        return lowestCommonAncestor;
    }

    private Stack<BinaryTree> getPath(BinaryTree tree, BinaryTree node) {
        if (tree==null) {
            return null;
        }

        if (tree.value == node.value) {
            Stack<BinaryTree> stack = new Stack<>();
            stack.push(tree);
            return stack;
        }

        Stack<BinaryTree> left = getPath(tree.left, node);
        if (left != null) {
            left.push(tree);
            return left;
        }

        Stack<BinaryTree> right = getPath(tree.right, node);
        if (right!=null) {
            right.push(tree);
            return right;
        }
        return null;
    }

    /** Right Side View **/
    public List<Integer> rightSideView(BinaryTree tree) {
        List<Integer> rightSideViewNodes = new ArrayList<>();

        if (tree != null) {
            Queue<BinaryTree> nextToVisit = new LinkedList<>();
            nextToVisit.offer(tree);

            while (!nextToVisit.isEmpty()) {
                int levelSize = nextToVisit.size();
                for (int i = 0; i < levelSize; i++) {
                    BinaryTree current = nextToVisit.poll();
                    if (i == levelSize - 1) {
                        rightSideViewNodes.add(current.value);
                    }
                    if (current.left != null) {
                        nextToVisit.offer(current.left);
                    }
                    if (current.right != null) {
                        nextToVisit.offer(current.right);
                    }
                }
            }
        }
        return rightSideViewNodes;
    }

    /** K Distant Node **/
    public ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
        HashMap<BinaryTree, BinaryTree> parents = new HashMap<>();
        BinaryTree targetNode = getTarget(tree, null, parents, target);

        Queue<BinaryTree> nextToVisit = new LinkedList<>();
        nextToVisit.offer(targetNode);
        Set<BinaryTree> seen = new HashSet<>();
        seen.add(targetNode);
        int level = 0; // distance

        while (!nextToVisit.isEmpty()) {
            int levelSize = nextToVisit.size();
            for (int i = 0; i < levelSize; i++) {
                if (level == k) {
                    ArrayList<Integer> nodesAtKDistance = new ArrayList<>();
                    for (BinaryTree node : nextToVisit)
                        nodesAtKDistance.add(node.value);
                    return nodesAtKDistance;
                }

                BinaryTree current = nextToVisit.poll();

                //Left
                if (current.left != null && !seen.contains(current.left)) {
                    seen.add(current.left);
                    nextToVisit.offer(current.left);
                }

                //Right
                if (current.right != null && !seen.contains(current.right)) {
                    seen.add(current.right);
                    nextToVisit.offer(current.right);
                }

                //Parent
                BinaryTree parent = parents.get(current);
                if (parent != null && !seen.contains(parent)) {
                    seen.add(parent);
                    nextToVisit.offer(parent);
                }
            }
            level++;
        }
        return new ArrayList<Integer>();
    }

    public static BinaryTree getTarget(BinaryTree tree, BinaryTree parent, HashMap<BinaryTree, BinaryTree> parents, int target) {
        if (tree == null) {
            return null;
        }

        parents.put(tree, parent);

        if (tree.value == target) {
            return tree;
        }

        if (getTarget(tree.left, tree, parents, target) != null) {
            return getTarget(tree.left, tree, parents, target);
        }

        return getTarget(tree.right, tree, parents, target);
    }

    /** Complete Leaf Traversal **/
    public boolean compareLeafTraversal(BinaryTree treeOne, BinaryTree treeTwo) {
        Stack<Integer> leafNodesOne = preOrderTraverse(treeOne, new Stack<>());
        Stack<Integer> leafNodesTwo = preOrderTraverse(treeTwo, new Stack<>());

        while (!leafNodesOne.isEmpty() && !leafNodesTwo.isEmpty()) {
            int value1 = leafNodesOne.pop();
            int value2 = leafNodesTwo.pop();
            if (value1 != value2) {
                return false;
            }
        }
        return leafNodesOne.size() == 0 && leafNodesTwo.size() == 0;
    }

    /** Two Elements with Sum **/
    public boolean twoSum(BinaryTree tree, int sum) {
        HashSet<Integer> set = new HashSet<>();
        return twoSum(tree, set, sum);
    }

    public boolean twoSum(BinaryTree tree, HashSet<Integer> set, int k){
        if (tree == null) {
            return false;
        }

        if (set.contains(k - tree.value)) {
            return true;
        } else {
            set.add(tree.value);
            return twoSum(tree.left, set, k) || twoSum(tree.right, set, k);
        }
    }

     /** All Path Sum **/
    public static List<Integer> pathSum(BinaryTree tree) {
        ArrayList<Integer> sums = new ArrayList<>();
        pathSum(tree, 0, sums);
        return sums;
    }

    public static void pathSum(BinaryTree tree, int runningSum, ArrayList<Integer> sums) {
        if (tree == null) {
            return;
        }

        runningSum += tree.value;
        if (tree.left == null && tree.right == null) {
            sums.add(runningSum);
            return;
        }
        pathSum(tree.left, runningSum, sums);
        pathSum(tree.right, runningSum, sums);
    }

    /** K Path Sum **/
    public static int countPathsWithSum(BinaryTree root, int targetSum) {
        HashMap<Integer, Integer> pathCount = new HashMap<>();
        return countPathsWithSum(root, targetSum, 0, pathCount);
    }

    public static int countPathsWithSum(BinaryTree node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) {
        if (node == null) {
            return 0;
        }

        runningSum += node.value;
        int sum = runningSum - targetSum;
        int totalPaths = pathCount.getOrDefault(sum, 0);
        if (runningSum == targetSum) {
            totalPaths++;
        }

        incrementHashTable(pathCount, runningSum, 1);
        totalPaths += countPathsWithSum(node.left, targetSum, runningSum, pathCount);
        totalPaths += countPathsWithSum(node.right, targetSum, runningSum, pathCount);
        incrementHashTable(pathCount, runningSum, -1);
        return totalPaths;
    }

    public static void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta) {
        int newCount = hashTable.getOrDefault(key, 0) + delta;
        if (newCount == 0) {
            hashTable.remove(key);
        } else {
            hashTable.put(key, newCount);
        }
    }

    /** All Vertical Sum **/
    public void verticalSum(BinaryTree tree) {
        verticalSum(tree, 0, new HashMap<Integer, Integer>());
    }

    public void verticalSum(BinaryTree tree, int verticalLevel, HashMap<Integer, Integer> verticalLevelSum) {
        if (tree == null) {
            return;
        }

        int sum = 0;
        verticalLevelSum.put(verticalLevel,verticalLevelSum.getOrDefault(verticalLevel,0) + tree.value);
        verticalSum(tree.left, verticalLevel - 1, verticalLevelSum);
        verticalSum(tree.right, verticalLevel + 1, verticalLevelSum);
    }

    public static Stack<Integer> preOrderTraverse(BinaryTree tree, Stack<Integer> stack) {
        if (tree == null) {
            return stack;
        }

        if (tree.left == null && tree.right == null) {
            stack.add(tree.value);
        }
        preOrderTraverse(tree.left, stack);
        preOrderTraverse(tree.right, stack);
        return stack;
    }

    /** Sum of Depths **/
    public static int nodeDepths(BinaryTree tree) {
        return nodeDepths(tree, 0);
    }

    public static int nodeDepths(BinaryTree tree, int depth) {
        if (tree == null) {
            return 0;
        }
        return depth + nodeDepths(tree.left, depth + 1) + nodeDepths(tree.right, depth + 1);
    }

    /** Sum of all subtree's Depths **/
    public static int allKindsOfNodeDepths(BinaryTree tree) {
        return nodeDepthsModified(tree, 0);
    }

    public static int nodeDepthsModified(BinaryTree tree, int depth) {
        if (tree == null) {
            return 0;
        }

        int depthSum = (depth * (depth + 1)) / 2;
        return depthSum + nodeDepthsModified(tree.left, depth + 1) + nodeDepthsModified(tree.right, depth + 1);
    }

    /** Topologies **/
    public static int numberOfBinaryTreeTopologies(int n) {
        if (n == 0) {
            return 1;
        }

        int totalCount = 0;
        for (int left = 0 ; left < n ; left++) {
            int right = n - 1 - left;
            int leftCount = numberOfBinaryTreeTopologies(left);
            int rightCount = numberOfBinaryTreeTopologies(right);
            totalCount += (leftCount * rightCount);
        }
        return totalCount;
    }
}