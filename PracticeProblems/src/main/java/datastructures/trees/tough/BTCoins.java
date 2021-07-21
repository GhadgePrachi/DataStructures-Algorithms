package datastructures.trees.tough;

public class BTCoins {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    static class TreeInfo {
        int totalMoves;
        int coinsMoved;

        public TreeInfo (int totalMoves, int coinsMoved) {
            this.totalMoves = totalMoves;
            this.coinsMoved = coinsMoved;
        }
    }

    public int distributeCoins(BinaryTree tree) {
        return distributeCoinsUtil(tree).totalMoves;
    }

    public TreeInfo distributeCoinsUtil(BinaryTree tree) {
        if (tree == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo left = distributeCoinsUtil(tree.left);
        TreeInfo right = distributeCoinsUtil(tree.right);
        int coinsMoved = left.coinsMoved + right.coinsMoved + tree.value - 1;
        int totalMoves = left.totalMoves  + right.totalMoves + Math.abs(coinsMoved);
        return new TreeInfo(totalMoves, coinsMoved);
    }
}
