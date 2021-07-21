package datastructures.arrays.tough;

import datastructures.arrays.verytough.BasicMath;

public class RotateArray {
    /** Rotate LEFT **/
    public int[] leftRotate(int array[], int k) {
        for (int i = 0; i < k; i++) {
            leftRotateByOne(array, array.length);
        }
        return array;
    }
    public void leftRotateByOne(int arr[], int n) {
        int temp = arr[0], i;
        for (i = 0; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[n-1] = temp;
    }

    public int[] leftRotateUsingReverse(int array[], int k) {
        reverse(array, 0, k);
        reverse(array, k + 1, array.length - 1);
        reverse(array, 0, array.length - 1);
        return array;
    }

    public void reverse(int[] array, int start, int end) {
        int left = start, right = end;
        while (left < end) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }
    }

    public int[] leftRotateUsingGCD(int[] array, int k) {
        k = k % array.length;
        int i, j, next, temp;
        int gcd = new BasicMath().gcd(k, array.length);
        for (i = 0; i < gcd; i++) {
            temp = array[i];
            j = i;
            do{
                next = j + k;
                if (next >= array.length) {
                    next = next % array.length;
                }
                if (next != i){
                    array[j] = array[next];
                    j = next;
                }
            } while (next != i);
            array[j] = temp;
        }
        return array;
    }

    /** Rotate RIGHT **/
    public int[] rightRotate(int array[], int k) {
        return leftRotate(array, array.length - k);
    }
}
