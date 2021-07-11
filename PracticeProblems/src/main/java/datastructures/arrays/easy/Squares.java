package datastructures.arrays.easy;

import java.util.Arrays;

public class Squares {
    /** Get Squares of Numbers **/
    public int[] sortedSquaredArray(int[] array) {
        int length = array.length;
        int[] squares = new int[length];
        int squareIndex = length - 1;
        int left = 0, right = length - 1;

        while (left <= right) {
            if (array[left] * array[left] >= array[right] * array[right]) {
                squares[squareIndex--] = array[left]*array[left];
                left++;
            } else {
                squares[squareIndex--] = array[right]*array[right];
                right--;
            }
        }
        return squares;
    }

    /** Get Max Products of K Numbers **/
    public static int subsequenceMaxProduct(int[] array, int n, int k) {
        Arrays.sort(array);
        int product = 1;

        //All Non-positive Numbers and odd k
        if (array[n - 1] == 0 && k % 2 != 0) {
            return 0;
        }

        //All Negative number and odd k
        if (array[n - 1] < 0 && k % 2 != 0) {
            for (int i = n - 1; i >= n - k; i--) {
                product *= array[i];
            }
            return product;
        }

        //Non-positive and Non-negative Numbers
        int left = 0, right = n - 1;
        if (k % 2 != 0) { //One odd K
            product *= array[right];
            right--;
            k--;
        }
        for (int i = 0; i < k / 2; i++) { // Remaining k/2 pairs
            int leftProduct = array[left] * array[left + 1];
            int rightProduct = array[right] * array[right - 1];
            if (leftProduct > rightProduct) {
                product *= leftProduct;
                left += 2;
            } else {
                product *= rightProduct;
                right -= 2;
            }
        }
        return product;
    }
}
