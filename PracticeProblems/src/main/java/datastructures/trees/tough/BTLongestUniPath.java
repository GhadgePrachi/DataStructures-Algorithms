package datastructures.trees.tough;

public class BTLongestUniPath {
    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    static class TreeInfo {
        int maxLength;
        int length;

        public TreeInfo( int maxLength, int length) {
            this.maxLength = maxLength;
            this.length = length;
        }
    }

    public int longestUniValuePath(BinaryTree tree) {
        return longestUniValuePathUtil(tree).maxLength;
    }

    public TreeInfo longestUniValuePathUtil(BinaryTree tree) {
        if (tree == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo left = longestUniValuePathUtil(tree.left);
        TreeInfo right = longestUniValuePathUtil(tree.right);

        if (tree.left != null && tree.left.value == tree.value) {
            left.length++;
        } else {
            left.length = 0;
        }

        if (tree.right != null && tree.right.value == tree.value) {
            right.length++;
        } else {
            right.length = 0;
        }
        int maxLength = Math.max(Math.max(left.maxLength, right.maxLength), left.length + right.length);
        int length = Math.max(left.length, right.length);
        return new TreeInfo(maxLength, length);
    }
}
