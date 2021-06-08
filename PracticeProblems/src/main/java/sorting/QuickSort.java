package sorting;

public class QuickSort {
    public static int[] quickSort(int[] array) {
        quickSort(array, 0, array.length-1);
        return array;
    }

    public static void quickSort(int[] array, int start, int end){
        if (start >= end)
            return;

        int pivot = partition(array, start, end);
        quickSort(array, start, pivot-1);
        quickSort(array, pivot+1, end);
    }

    public static int partition(int[] a, int left, int right) {
        int pivot = a[right];
        int i = left-1;
        for (int j = left; j < right; j++){
            if (a[j] < pivot) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i+1, right);
        return i+1;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
