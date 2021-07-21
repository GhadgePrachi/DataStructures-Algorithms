package datastructures.trees.tough;

public class BTLongestConsecutive {
    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    /** Longest Consecutive Path One **/
    static class TreeInfo {
        int maxLength;
        int length;

        public TreeInfo( int maxLength, int length) {
            this.maxLength = maxLength;
            this.length = length;
        }
    }

    public int longestConsecutive(BinaryTree root) {
        return longestConsecutive1Util(root).maxLength;
    }

    private TreeInfo longestConsecutive1Util(BinaryTree node) {
        if (node == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo left = longestConsecutive1Util(node.left);
        TreeInfo right = longestConsecutive1Util(node.right);

        if (node.left != null && node.left.value == node.value + 1) {
            left.length++;
        } else {
            left.length = 1;
        }

        if (node.right != null && node.right.value == node.value + 1) {
            right.length++;
        } else {
            right.length = 1;
        }

        int globalMaxLength = Math.max(left.maxLength, right.maxLength);
        int localMaxLength = Math.max(left.length,right.length);
        int maxLength = Math.max(globalMaxLength, localMaxLength);
        int length = Math.max(left.length,right.length);
        return new TreeInfo(maxLength, length);
    }

    /** Longest Consecutive Path Two **/
    static class TreeInfoTwo {
        int maxLength;
        int[] length;

        public TreeInfoTwo( int maxLength, int[] length) {
            this.maxLength = maxLength;
            this.length = length;
        }
    }

    public int longestConsecutiveTwo(BinaryTree tree) {
        return longestConsecutiveTwoUtil(tree).maxLength;
    }

    private TreeInfoTwo longestConsecutiveTwoUtil(BinaryTree tree) {
        if (tree == null) {
            return new TreeInfoTwo(0, new int[] {0, 0});
        }

        TreeInfoTwo left = longestConsecutiveTwoUtil(tree.left);
        TreeInfoTwo right = longestConsecutiveTwoUtil(tree.right);
        int leftIncreasing = left.length[0], leftDecreasing = left.length[1];
        int rightIncreasing = right.length[0], rightDecreasing = right.length[1];

        if (tree.left != null && tree.left.value == tree.value + 1) {
            leftIncreasing++;
        } else {
            leftIncreasing = 1;
        }

        if (tree.left != null && tree.left.value == tree.value - 1) {
            leftDecreasing++;
        } else {
            leftDecreasing = 1;
        }

        if(tree.right != null && tree.right.value == tree.value + 1) {
            rightIncreasing++;
        } else {
            rightIncreasing = 1;
        }

        if (tree.right != null && tree.right.value == tree.value - 1) {
            rightDecreasing++;
        } else {
            rightDecreasing = 1;
        }

        int globalMaxLength = Math.max(left.maxLength, right.maxLength);
        int localMaxLength = Math.max(leftIncreasing + rightDecreasing - 1, rightIncreasing + leftDecreasing - 1);
        int maxLength = Math.max(globalMaxLength, localMaxLength);
        int[] length  = new int[]{Math.max(leftIncreasing, rightIncreasing), Math.max(leftDecreasing, rightDecreasing)};
        return new TreeInfoTwo(maxLength, length);
    }
}
