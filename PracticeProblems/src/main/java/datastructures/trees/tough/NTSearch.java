package datastructures.trees.tough;

public class NTSearch {
    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }

    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        int depthOne = getDepth(topAncestor, descendantOne);
        int depthTwo = getDepth(topAncestor, descendantTwo);
        int difference = Math.abs(depthOne - depthTwo);
        if (depthOne > depthTwo) {
            return getYoungestCommonAncestor(topAncestor, descendantOne, descendantTwo, difference);
        } else {
            return getYoungestCommonAncestor(topAncestor, descendantTwo, descendantOne, difference);
        }
    }

    public static int getDepth(AncestralTree topAncestor, AncestralTree descendant) {
        int depth = 0;
        while (descendant != null && descendant != topAncestor) {
            descendant = descendant.ancestor;
            depth++;
        }
        return depth;
    }

    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo, int difference) {
        while (difference > 0) {
            descendantOne = descendantOne.ancestor;
            difference--;
        }

        while (descendantOne != descendantTwo) {
            descendantOne = descendantOne.ancestor;
            descendantTwo = descendantTwo.ancestor;
        }
        return descendantOne;
    }
}
