package datastructures.trees.tough;

public class BTMaxSum {
    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    static class TreeInfo {
        int maxSum;
        int maxPathSum;

        public TreeInfo (int maxSum, int maxPathSum) {
            this.maxSum = maxSum;
            this.maxPathSum = maxPathSum;
        }
    }

    public static int maxPathSum(BinaryTree tree) {
        return maxPathSumUtil(tree).maxSum;
    }

    public static TreeInfo maxPathSumUtil(BinaryTree tree) {
        if (tree == null) {
            return new TreeInfo(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }

        TreeInfo left = maxPathSumUtil(tree.left);
        TreeInfo right = maxPathSumUtil(tree.right);
        int leftPathSum = Math.max(left.maxPathSum, 0);
        int rightPathSum = Math.max(right.maxPathSum, 0);
        int maxSum = Math.max(Math.max(left.maxSum, right.maxSum), leftPathSum + rightPathSum + tree.value);
        int maxPathSum = Math.max(leftPathSum, rightPathSum) + tree.value;
        return new TreeInfo(maxSum, maxPathSum);
    }
}
