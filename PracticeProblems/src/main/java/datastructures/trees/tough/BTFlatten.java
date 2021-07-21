package datastructures.trees.tough;

public class BTFlatten {
    static class BinaryTree {
        int value;
        BinaryTree left = null;
        BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static BinaryTree flatten(BinaryTree root) {
        return flattenUtil(root)[0];
    }

    public static BinaryTree[] flattenUtil(BinaryTree tree) {
        if (tree == null) {
            return new BinaryTree[]{null, null};
        }

        BinaryTree leftMost = null;
        BinaryTree rightMost = null;
        if (tree.left == null) {
            leftMost = tree;
        } else {
            BinaryTree[] left = flattenUtil(tree.left);
            leftMost = left[0];
            connect(left[1], tree);
        }

        if (tree.right == null) {
            rightMost = tree;
        } else {
            BinaryTree[] right = flattenUtil(tree.right);
            rightMost = right[1];
            connect(tree, right[0]);
        }
        return new BinaryTree[] {leftMost, rightMost};
    }

    public static void connect(BinaryTree nodeOne, BinaryTree nodeTwo) {
        nodeOne.right = nodeTwo;
        nodeTwo.left = nodeOne;
    }
}
