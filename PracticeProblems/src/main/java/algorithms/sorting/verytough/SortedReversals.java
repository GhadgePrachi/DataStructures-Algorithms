package algorithms.sorting.verytough;

import java.util.Arrays;

public class SortedReversals {
    public static int countInversions(int[] array) {
        return mergeSort(array, 0, array.length-1);
    }

    public static int mergeSort(int[] array, int start, int end){
        if (start >= end)
            return 0;

        int mid = start + (end-start)/2;
        int leftInversions = mergeSort(array, start, mid);
        int rightInversions = mergeSort(array, mid+1, end);
        int mergedArrayInversions = merge(array, start, mid, end);
        return leftInversions + rightInversions + mergedArrayInversions;
    }

    public static int merge(int[] array, int left, int mid, int right) {
        int[] leftHalf = Arrays.copyOfRange(array, left, mid+1);
        int[] rightHalf = Arrays.copyOfRange(array, mid+1,right+1);
        int i = 0, j = 0, k = left;
        int inversions = 0;

        while (i < leftHalf.length && j < rightHalf.length) {
            if (leftHalf[i] <= rightHalf[j]){
                array[k++] = leftHalf[i++];
            } else {
                inversions += (leftHalf.length  - i);
                array[k++] = rightHalf[j++];
            }
        }

        while (i < leftHalf.length) {
            array[k++] = leftHalf[i++];
        }

        while (j < rightHalf.length) {
            array[k++] = rightHalf[j++];
        }

        return inversions;
    }
}
