package datastructures.trees.medium;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class BTConstruct {
    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    /** Construct Maximum Tree **/
    public BinaryTree maximumBinaryTree(int[] array) {
        return maximumBinaryTree(array, 0, array.length-1);
    }

    public BinaryTree maximumBinaryTree(int[] array, int start, int end) {
        if (start > end) {
            return null;
        }

        int maxIndex = max(array, start, end);
        BinaryTree tree = new BinaryTree(array[maxIndex]);
        tree.left = maximumBinaryTree(array, start, maxIndex-1);
        tree.right = maximumBinaryTree(array, maxIndex + 1, end);
        return tree;
    }

    public int max(int[] array, int start, int end) {
        int maxIndex = start;
        for (int i = start; i <= end; i++) {
            if (array[maxIndex] < array[i]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    /** Construct with InOrder and PostOrder **/
    public BinaryTree buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
            return null;
        }

        //Build Root node with root value
        int rootValue = postorder[postorder.length - 1];
        BinaryTree root = new BinaryTree(rootValue);

        //Build Root.left subtree
        int rootIndex = getIndex(rootValue,inorder);
        int inOrderStart = 0;
        int inOrderEnd = rootIndex;
        int postOrderStart = 0;
        int postOrderEnd = rootIndex;
        if (inOrderStart > inOrderEnd || postOrderStart > postOrderEnd) {
            root.left = null;
        } else {
            root.left = buildTree(Arrays.copyOfRange(inorder, inOrderStart, inOrderEnd), Arrays.copyOfRange(postorder, postOrderStart, postOrderEnd));
        }

        //Build Root.right subtree
        inOrderStart = rootIndex + 1;
        inOrderEnd = inorder.length;
        postOrderStart = rootIndex;
        postOrderEnd = postorder.length - 1;
        if(inOrderStart > inOrderEnd || postOrderStart > postOrderEnd || postOrderEnd < 0) {
            root.right = null;
        } else {
            root.right = buildTree(Arrays.copyOfRange(inorder, inOrderStart, inOrderEnd), Arrays.copyOfRange(postorder, postOrderStart, postOrderEnd));
        }

        //Return Root
        return root;
    }

    /** Construct with PreOrder and InOrder **/
    public BinaryTree buildTreeTwo(int[] inorder, int[] preorder) {
        if (inorder == null || inorder.length == 0 || preorder == null || preorder.length == 0) {
            return null;
        }

        //Build Root node with root value
        int rootValue = preorder[0];
        BinaryTree root = new BinaryTree(rootValue);

        //Build Root.left subtree
        int rootIndex = getIndex(rootValue, inorder);
        int inOrderStart = 0;
        int inOrderEnd = rootIndex;
        int preOrderStart = 1;
        int preOrderEnd = rootIndex + 1;
        if (inOrderStart > inOrderEnd || preOrderStart > preOrderEnd) {
            root.left = null;
        } else {
            root.left = buildTree(Arrays.copyOfRange(inorder, inOrderStart, inOrderEnd), Arrays.copyOfRange(preorder, preOrderStart, preOrderEnd));
        }

        //Build Root.right subtree
        inOrderStart = rootIndex + 1;
        inOrderEnd = inorder.length;
        preOrderStart = 1 + rootIndex;
        preOrderEnd = preorder.length;
        if (inOrderStart > inOrderEnd || preOrderStart > preOrderEnd) {
            root.right = null;
        } else {
            root.right = buildTree(Arrays.copyOfRange(inorder, inOrderStart, inOrderEnd), Arrays.copyOfRange(preorder, preOrderStart, preOrderEnd));
        }

        //Return Root
        return root;
    }

    public int getIndex(int value, int[] a){
        for (int i = 0; i < a.length; i++){
            if (a[i] == value) {
                return i;
            }
        }
        return -1;
    }

    /** Serialize-Deserialize BT **/
    private static final String splitter = ",";//optional
    private static final String delimiter = "#";

    public String serialize(BinaryTree tree) {
        StringBuilder sb = new StringBuilder();
        buildString(tree, sb);
        return sb.toString();
    }

    private void buildString(BinaryTree tree, StringBuilder sb) {
        if (tree == null) {
            sb.append(delimiter).append(splitter);
            return;
        } else {
            sb.append(tree.value).append(splitter);
            buildString(tree.left, sb);
            buildString(tree.right,sb);
        }
    }

    public BinaryTree deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(splitter)));
        return buildTree(nodes);
    }

    private BinaryTree buildTree(Deque<String> nodes) {
        if (nodes == null) {
            return null;
        }

        String val = nodes.remove();
        if (val.equals(delimiter)) {
            return null;
        } else {
            BinaryTree node = new BinaryTree(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}