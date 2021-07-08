package datastructures.arrays.tough;

import datastructures.arrays.verytough.BasicMath;

public class RotateArray {
    public void leftRotate(int array[], int k) {
        for (int i = 0; i < k; i++) {
            leftRotateByOne(array, array.length);
        }
    }
    public void leftRotateByOne(int arr[], int n) {
        int temp = arr[0], i;
        for (i = 0; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[n-1] = temp;
    }

    public void leftRotateUsingReverse(int array[], int k) {
        reverse(array, 0, k);
        reverse(array, k + 1, array.length - 1);
        reverse(array, 0, array.length - 1);

    }

    public void reverse(int[] array, int start, int end) {
        int left = start, right = end;
        while (left < end) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }
    }

    public void leftRotateUsingGCD(int[] array, int k) {
        int n = array.length;
        k = k % n;
        int i, j, d, temp;
        int gcd = new BasicMath().gcd(k, n);
        for (i = 0; i < gcd; i++) {
            temp = array[i];
            j = i;
            do{
                d = j + k;
                if (d >= n) {
                    d = d - n;
                }
                array[j] = array[d];
                j = d;
            } while (d != i);
            array[j] = temp;
        }
    }
}
