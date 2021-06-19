package algorithms.sorting.verytough;

import java.util.Arrays;

public class MergeSort {
    public static int[] mergeSort(int[] array) {
        mergeSort(array, 0, array.length-1);
        return array;
    }

    public static void mergeSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end-start)/2;
        mergeSort(array, start, mid);
        mergeSort(array, mid+1, end);
        merge(array, start, mid, end);
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int[] leftHalf = Arrays.copyOfRange(array, left, mid+1);
        int[] rightHalf = Arrays.copyOfRange(array, mid+1,right+1);
        int i = 0, j = 0, k = left;

        while (i < leftHalf.length && j < rightHalf.length) {
            if (leftHalf[i] <= rightHalf[j]) {
                array[k++] = leftHalf[i++];
            } else {
                array[k++] = rightHalf[j++];
            }
        }

        while (i < leftHalf.length) {
            array[k++] = leftHalf[i++];
        }

        while (j < rightHalf.length) {
            array[k++] = rightHalf[j++];
        }
    }
}
