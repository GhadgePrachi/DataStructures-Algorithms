package datastructures.arrays.easy;

public class ArrayOfProducts {
    public int[] arrayOfProducts(int[] array) {
        int length = array.length;
        int[] product = new int[length];

        int leftRunningProduct = 1;
        for (int i = 0; i < length; i++) {
            product[i] = leftRunningProduct;
            leftRunningProduct *= array[i];
        }

        int rightRunningProduct= 1;
        for (int i = length - 1; i >= 0; i--) {
            product[i] *= rightRunningProduct;
            rightRunningProduct *= array[i];
        }
        return product;
    }
}
