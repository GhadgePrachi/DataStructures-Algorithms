package datastructures.trees.tough;

public class BSTModify {
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    /** Convert to Greater BST **/
    class TreeInfo {
        int sum;
        public TreeInfo(int sum) {
            this.sum = sum;
        }
    }

    public BST convertBST(BST tree) {
        TreeInfo treeInfo = new TreeInfo(0);
        convertBST(tree, treeInfo);
        return tree;
    }

    public void convertBST(BST tree, TreeInfo treeInfo) {
        if (tree == null) {
            return;
        }

        convertBST(tree.right, treeInfo);
        treeInfo.sum += tree.value;
        tree.value = treeInfo.sum;
        convertBST(tree.left, treeInfo);
    }
}
