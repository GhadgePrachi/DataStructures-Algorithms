package algorithms.sorting.medium;

public class SortThree {
    public static int[] sortThree(int[] array, int[] order) {
        int low = 0, mid = 0, high = array.length-1;
        int first = order[0], second = order[1], third = order[2];
        while(mid <= high) {
            if (array[mid] == first){
                swap(array, low, mid);
                low += 1;
                mid += 1;
            } else if (array[mid] == second){
                mid += 1;
            } else if (array[mid] == third){
                swap(array, mid, high);
                high -= 1;
            }
        }
        return array;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
