package sorting;

public class HeapSort {
    public static int[] heapSort(int[] array) {
        buildHeap(array);
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, i, 0);
            heapifyDown(array, i, 0);
        }
        return array;
    }

    public static void buildHeap(int[] array){
        int lastElementIndex = array.length - 1;
        int firstParentIndex = (lastElementIndex - 1)/2;
        for (int i = firstParentIndex; i >= 0; i--)
            heapifyDown(array, array.length, i);
    }
    public static void heapifyDown(int a[], int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && a[left] > a[largest])
            largest = left;

        if (right < n && a[right] > a[largest])
            largest = right;

        if (largest != i) {
            swap(a, i, largest);
            heapifyDown(a, n, largest);
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
