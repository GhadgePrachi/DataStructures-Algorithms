package datastructures.trees.medium;

public class BTSubTree {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    /** Contains SubTree **/
    public static boolean containsTreeUsingSerialization(BinaryTree treeOne, BinaryTree treeTwo) {
        StringBuilder string1 = new StringBuilder();
        StringBuilder string2 = new StringBuilder();

        getOrderString(treeOne, string1);
        getOrderString(treeTwo, string2);

        return string1.indexOf(string2.toString()) != -1;
    }

    public static String DELIMITER = "X";//or "NULL"
    public static void getOrderString(BinaryTree node, StringBuilder sb) {
        if (node == null) {
            sb.append(DELIMITER);
            return;
        }
        sb.append(node.value);
        getOrderString(node.left, sb);
        getOrderString(node.right, sb);
    }

    public static boolean containsTree(BinaryTree treeOne, BinaryTree treeTwo) {
        if (treeTwo == null) {
            return true; // The empty tree is a subtree of every tree.
        }
        return subTree(treeOne, treeTwo);
    }

    public static boolean subTree(BinaryTree treeOne, BinaryTree treeTwo) {
        if (treeOne == null) {
            return false; // big tree empty & subtree still not found.
        } else if (treeOne.value == treeTwo.value && matchTree(treeOne,treeTwo)) {
            return true;
        }
        return subTree(treeOne.left, treeTwo) || subTree(treeOne.right, treeTwo);
    }

    public static boolean matchTree(BinaryTree treeOne, BinaryTree treeTwo) {
        if (treeOne == null && treeTwo == null) {
            return true; // nothing left in the subtree
        } else if (treeOne == null || treeTwo == null) {
            return false; // exactly tree is empty, therefore trees don't match
        } else if (treeOne.value != treeTwo.value) {
            return false;  // data doesn't match
        } else {
            return matchTree(treeOne.left, treeTwo.left) && matchTree(treeOne.right, treeTwo.right);
        }
    }
}