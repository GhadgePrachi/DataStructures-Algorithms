package datastructures.trees.medium;

public class BSTSearch {
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    /** Closest Element **/
    public static int findClosestValueInBST(BST tree, int target) {
        int closestValue = -1;

        if (tree != null) {
            closestValue = tree.value;
            while (tree != null) {
                if (Math.abs(target - closestValue) > Math.abs(target - tree.value)) {
                    closestValue = tree.value;
                }

                if (tree.value < target) {
                    tree = tree.right;
                } else if (tree.value > target) {
                    tree = tree.left;
                } else {
                    return target;
                }
            }
        }
        return closestValue;
    }

    /** Lowest Common Ancestor **/
    public BST lowestCommonAncestorIterative(BST tree, BST nodeOne, BST nodeTwo) {
        if (tree != null) {
            while (tree != null) {
                if (tree.value < nodeOne.value && tree.value < nodeTwo.value) {
                    tree = tree.right;
                } else if (tree.value > nodeOne.value && tree.value > nodeTwo.value) {
                    tree = tree.left;
                } else {
                    return tree;
                }
            }
        }
        return null;
    }

    /** Descendant **/
    public boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {
        if (isDescendant(nodeThree, nodeTwo)) {
            return isDescendant(nodeTwo, nodeOne);
        }
        if (isDescendant(nodeTwo, nodeThree)) {
            return isDescendant(nodeOne, nodeTwo);
        }
        return false;
    }

    public static boolean isDescendant(BST nodeOne, BST nodeTwo) {
        while (nodeOne != null && nodeOne != nodeTwo) {
            if (nodeOne.value > nodeTwo.value) {
                nodeOne = nodeOne.left;
            } else {
                nodeOne = nodeOne.right;
            }
        }
        return nodeOne == nodeTwo;
    }
}