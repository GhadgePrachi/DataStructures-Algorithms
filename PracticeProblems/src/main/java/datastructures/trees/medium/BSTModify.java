package datastructures.trees.medium;

public class BSTModify {
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    /** Trim BST **/
    public BST trimBST(BST tree, int L, int R) {
        if (tree == null) {
            return null;
        }

        if (tree.value < L) {
            return trimBST(tree.right, L, R);
        }

        if (tree.value > R) {
            return trimBST(tree.left, L, R);
        }

        tree.left = trimBST(tree.left, L, R);
        tree.right = trimBST(tree.right, L, R);
        return tree;
    }
}