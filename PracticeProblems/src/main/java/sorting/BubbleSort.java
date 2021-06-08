package sorting;

public class BubbleSort {
    public static int[] bubbleSort(int[] array) {
        int lastUnsorted = array.length -1;
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < lastUnsorted; i++) {
                if (array[i] > array[i+1]) {
                    swap(array, i , i+1);
                    isSorted = false;
                }
            }
            lastUnsorted--;
        }
        return array;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
