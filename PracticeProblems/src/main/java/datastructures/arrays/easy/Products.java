package datastructures.arrays.easy;

public class Products {
    public int[] arrayOfProducts(int[] array) {
        int length = array.length;
        int[] products = new int[length];

        int leftRunningProduct = 1;
        for (int i = 0; i < length; i++) {
            products[i] = leftRunningProduct;
            leftRunningProduct *= array[i];
        }

        int rightRunningProduct= 1;
        for (int i = length - 1; i >= 0; i--) {
            products[i] *= rightRunningProduct;
            rightRunningProduct *= array[i];
        }
        return products;
    }
}
