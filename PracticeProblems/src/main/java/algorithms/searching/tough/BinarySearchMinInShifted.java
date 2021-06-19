package algorithms.searching.tough;

public class BinarySearchMinInShifted {
    public int findMin(int[] array) {
        int left = 0, right = array.length - 1;
        if (array[left] < array[right] || array.length == 1) {
            return array[0];
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid + 1 < array.length && array[mid] > array[mid + 1]) {
                return array[mid + 1];
            } else if (mid - 1 >= 0 && array[mid - 1] > array[mid]) {
                return array[mid];
            } else if (array[left] < array[mid]) {
                left = mid + 1;
            } else if (array[left] > array[mid]) {
                right = mid - 1;
            } else {//equal
                left++;
            }
        }
        return -1;
    }
}
