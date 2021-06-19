package algorithms.sorting.tough;

public class HeapSort {
    public static int[] heapSort(int[] array) {
        buildHeap(array);
        sortHeap(array);
        return array;
    }

    public static void buildHeap(int[] array) {
        int lastElementIndex = array.length - 1;
        int firstParentIndex = (lastElementIndex - 1)/2;
        for (int i = firstParentIndex; i >= 0; i--) {
            heapifyDown(array, array.length, i);
        }
    }

    public static void sortHeap(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, i, 0);
            heapifyDown(array, i, 0);
        }
    }

    public static void heapifyDown(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(array, i, largest);
            heapifyDown(array, n, largest);
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
