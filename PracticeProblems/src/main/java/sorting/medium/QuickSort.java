package sorting.medium;

public class QuickSort {
    public static int[] quickSort(int[] array) {
        quickSort(array, 0, array.length-1);
        return array;
    }

    public static void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = partition(array, start, end);
        quickSort(array, start, pivot-1);
        quickSort(array, pivot+1, end);
    }

    public static int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int i = left-1;
        for (int j = left; j < right; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i+1, right);
        return i+1;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
