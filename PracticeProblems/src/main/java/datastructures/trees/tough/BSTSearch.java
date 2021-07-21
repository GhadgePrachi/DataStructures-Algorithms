package datastructures.trees.tough;

public class BSTSearch {
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    static class TreeInfo {
        int count;
        int latestNodeValue;

        public TreeInfo(int count, int latestNodeValue) {
            this.count = count;
            this.latestNodeValue = latestNodeValue;
        }
    }

    public int findKthLargestValue(BST tree, int k) {
        TreeInfo treeInfo = new TreeInfo(0,-1);
        findKthLargestValue(tree, k, treeInfo);
        return treeInfo.latestNodeValue;
    }

    public void findKthLargestValue(BST tree, int k, TreeInfo treeInfo) {
        if (tree == null) {
            return;
        }

        findKthLargestValue(tree.right, k, treeInfo);
        treeInfo.count++;
        if (treeInfo.count == k) {
            treeInfo.latestNodeValue = tree.value;
        }
        findKthLargestValue(tree.left, k, treeInfo);
    }
}