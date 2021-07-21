package datastructures.trees.tough;

public class BTHeightBalanced {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public boolean heightBalanced(BinaryTree tree) {
        return heightBalancedUtil(tree) == -1 ? false : true;
    }

    public int heightBalancedUtil(BinaryTree tree) {
        if (tree == null) {
            return 0;
        }

        int leftHeight = heightBalancedUtil(tree.left);
        int rightHeight = heightBalancedUtil(tree.right);
        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(heightBalancedUtil(tree.left), heightBalancedUtil(tree.right)) + 1;
    }
}
