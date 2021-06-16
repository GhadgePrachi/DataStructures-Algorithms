package sorting.medium;

public class QuickSelect {
    public static int quickselect(int[] array, int k) {
        return quickSelect(array, k , 0, array.length-1);
    }

    public static int quickSelect(int[] array, int k, int left, int right) {
        while(left <= right){
            int pivot = partition(array, left, right);
            if (pivot == k-1) {
                return array[pivot];
            } else if (pivot < k-1) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return -1;
    }

    public static int partition(int[] array, int left, int right) {
        int i = left-1;
        int pivot = array[right];
        for (int j = left; j < right; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i , j);
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
