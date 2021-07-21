package datastructures.trees.tough;

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

    /** SubTree with Deepest Nodes **/
    static class TreeInfo {
        int deepestLevel; //height
        BinaryTree deepestNode;

        public TreeInfo(int deepestLevel, BinaryTree deepestNode) {
            this.deepestLevel = deepestLevel;
            this.deepestNode = deepestNode;
        }
    }

    public BinaryTree subtreeWithAllDeepest(BinaryTree tree) {
        return subtreeWithAllDeepestUtil(tree).deepestNode;
    }

    private TreeInfo subtreeWithAllDeepestUtil(BinaryTree tree) {
        if (tree == null) {
            return new TreeInfo(0, null);
        }

        TreeInfo left = subtreeWithAllDeepestUtil(tree.left);
        TreeInfo right = subtreeWithAllDeepestUtil(tree.right);

        if (left.deepestLevel < right.deepestLevel) {
            return new TreeInfo(right.deepestLevel + 1, right.deepestNode);
        } else  if (left.deepestLevel > right.deepestLevel) {
            return new TreeInfo(left.deepestLevel + 1, left.deepestNode);
        } else {
            return new TreeInfo(left.deepestLevel + 1, tree);
        }
    }
}