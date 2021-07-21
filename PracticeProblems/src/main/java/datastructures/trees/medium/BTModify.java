package datastructures.trees.medium;

import java.util.LinkedList;
import java.util.Queue;

public class BTModify {
    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    /** Invert **/
    public static void invertBinaryTree(BinaryTree tree) {
        if (tree == null) {
            return;
        }

        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);
        BinaryTree temp = tree.left;
        tree.left = tree.right;
        tree.right = temp;
    }

    /** Prune Tree **/
    public BinaryTree pruneBinaryTree(BinaryTree tree) {
        if(tree == null) {
            return null;
        }

        tree.left = pruneBinaryTree(tree.left);
        tree.right = pruneBinaryTree(tree.right);
        return (tree.right == null && tree.left == null && tree.value == 0) ? null : tree;
    }

    /** Upside Down **/
    public BinaryTree upsideDownBinaryTree(BinaryTree tree) {
        if (tree == null || tree.left == null && tree.right == null) {
            return tree;
        }

        BinaryTree newRoot = upsideDownBinaryTree(tree.left);
        tree.left.left = tree.right;
        tree.left.right = tree;
        tree.left = null;
        tree.right = null;
        return newRoot;
    }

    /** Right Sibling **/
    public static BinaryTree rightSiblingBinaryTree(BinaryTree tree) {
        Queue<BinaryTree> nextToVisit = new LinkedList<>();
        nextToVisit.offer(tree);

        while (!nextToVisit.isEmpty()) {
            int levelElements = nextToVisit.size();
            BinaryTree previous = null;
            for (int i = 0; i < levelElements; i++) {
                BinaryTree node = nextToVisit.poll();
                if (node == null) {
                    previous = null;
                    continue;
                }

                if (previous != null) {
                    previous.right = node;
                }
                previous = node;

                nextToVisit.offer(node.left);
                nextToVisit.offer(node.right);
            }

            if (previous != null) {
                previous.right = null;
            }
        }
        return tree;
    }
}