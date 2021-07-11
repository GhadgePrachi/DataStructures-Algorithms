package datastructures.arrays.tough;

public class RotateBits {
    public static final int INT_BITS = 32;

    public  int leftRotate(int n, int d) {
        return (n << d) | (n >> (INT_BITS - d));
    }

    public int rightRotate(int n, int d) {
        return (n >> d) | (n << (INT_BITS - d));
    }
}
