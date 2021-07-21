package datastructures.trees.easy;

public class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
        this.value = value;
    }

    public BST insert(int value) {
        if (value < this.value) {
            if (left == null) {
                BST node = new BST(value);
                this.left = node;
            } else {
                this.left.insert(value);
            }
        } else {
            if (right == null) {
                BST node = new BST(value);
                this.right = node;
            } else {
                this.right.insert(value);
            }
        }
        return this;
    }

    public boolean contains(int value) {
        if (value < this.value) {
            if (left == null) {
                return false;
            } else {
                return this.left.contains(value);
            }
        } else if (value > this.value) {
            if (right == null) {
                return false;
            } else {
                return this.right.contains(value);
            }
        }
        return true;
    }

    public BST remove(int value) {
        remove(value, null);
        return this;
    }

    public void remove(int value, BST parent) {
        if (value < this.value) {
            if (this.left != null) {
                this.left.remove(value, this);
            }
        } else if (value > this.value) {
            if (this.right != null) {
                this.right.remove(value, this);
            }
        } else {
            if (this.left != null && this.right != null) {
                this.value = this.right.getMin();
                this.right.remove(this.value, this);
            } else if (parent == null) {
                if (left != null) {
                    this.value = this.left.value;
                    this.right = this.left.right;
                    this.left = this.left.left;
                } else if (right != null) {
                    this.value = this.right.value;
                    this.left = this.right.left;
                    this.right = this.right.right;
                } else {
                    //do nothing
                }
            } else if (parent.left == this) {
                parent.left = left != null ? left : right;
            } else if (parent.right == this) {
                parent.right = right != null ? right : left;
            }
        }
    }

    public int getMin() {
        BST current = this;
        while (current.left != null) {
            current = current.left;
        }
        return current.value;
    }
}