package datastructures.trees.tough;

public class BTDiameter {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    static class TreeInfo {
        int diameter;
        int height;

        public TreeInfo(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    public int diameter(BinaryTree tree) {
        return diameterUtil(tree).diameter;
    }

    public static TreeInfo diameterUtil(BinaryTree tree) {
        if (tree == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo left = diameterUtil(tree.left);
        TreeInfo right = diameterUtil(tree.right);
        int globalDiameter = Math.max(left.diameter, right.diameter);
        int localDiameter = left.height + right.height;
        int diameter = Math.max(globalDiameter, localDiameter);
        int height = Math.max(left.height, right.height) + 1;
        return new TreeInfo(diameter, height);
    }
}
