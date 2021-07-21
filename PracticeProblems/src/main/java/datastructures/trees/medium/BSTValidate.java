package datastructures.trees.medium;

import java.util.ArrayList;
import java.util.List;

public class BSTValidate {
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    /** Valid BST **/
    public static boolean validateBST(BST tree) {
        return validateBST(tree, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public static boolean validateBST(BST tree, int min, int max) {
        if (tree == null) {
            return true;
        }

        if (tree.value < min || tree.value >= max) {
            return false;
        }

        return validateBST(tree.left, min, tree.value) && validateBST(tree.right, tree.value, max);
    }

    /** Similar BSTs**/
    public static boolean sameBST(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if (arrayOne.size() != arrayTwo.size()) {
            return false;
        }

        if (arrayOne.size() == 0 && arrayTwo.size() == 0) {
            return true;
        }

        if (arrayOne.get(0) != arrayTwo.get(0)) {
            return false;
        }

        List<Integer> leftOne = getSmaller(arrayOne);
        List<Integer> leftTwo = getSmaller(arrayTwo);
        List<Integer> rightOne = getBigger(arrayOne);
        List<Integer> rightTwo = getBigger(arrayTwo);

        return sameBST(leftOne, leftTwo) && sameBST(rightOne, rightTwo);
    }

    public static List<Integer> getSmaller(List<Integer> array) {
        List<Integer> smaller = new ArrayList<>();
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) < array.get(0).intValue()) {
                smaller.add(array.get(i));
            }
        }
        return smaller;
    }

    public static List<Integer> getBigger(List<Integer> array) {
        List<Integer> bigger = new ArrayList<>();
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) >= array.get(0).intValue())
                bigger.add(array.get(i));
        }
        return bigger;
    }
}