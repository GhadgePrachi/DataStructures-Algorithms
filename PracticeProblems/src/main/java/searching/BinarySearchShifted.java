package searching;

public class BinarySearchShifted {
    public static int shiftedBinarySearch(int[] array, int target) {
        return shiftedBinarySearch(array, 0 , array.length - 1, target);
    }

    public static int shiftedBinarySearch(int[] array, int left, int right, int target) {
        if (left > right)
            return -1;

        int mid = left + (right - left)/2;
        if (array[mid] == target) {
            return mid;
        } else if (array[left] < array[mid]) { //left half sorted
            if (array[left] <= target && array[mid] > target){
                return shiftedBinarySearch(array, left, mid - 1, target);
            } else {
                return shiftedBinarySearch(array, mid + 1, right, target);
            }
        } else if (array[left] > array[mid]) { //right half sorted
            if (array[mid] < target && array[right] >= target){
                return shiftedBinarySearch(array, mid + 1, right, target);
            } else {
                return shiftedBinarySearch(array, left, mid - 1, target);
            }
        } else { //if (array[left] == array[mid]) --> duplicates
            int result = shiftedBinarySearch(array, left, mid - 1, target);
            if (result != -1) {
                return result;
            } else {
                return shiftedBinarySearch(array, mid + 1, right, target);
            }
        }
    }
}
