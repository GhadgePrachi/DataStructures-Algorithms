package searching;

public class BinarySearchRange {
    public static int[] searchForRange(int[] array, int target) {
        int startIndex = searchFirstOccurrence(array, target);
        int endIndex = searchLastOccurrence(array, target);
        return new int[] {startIndex, endIndex};
    }

    public static int searchFirstOccurrence(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if (array[mid] == target && (mid == 0 || array[mid-1] != target)){
                return mid;
            } else if (array[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;// lesser than target and equal to target
            }
        }
        return -1;
    }

    public static int searchLastOccurrence(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if (array[mid] == target && (mid == array.length-1 || array[mid+1] != target)){
                return mid;
            } else if (array[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;// greater than target and equal to target
            }
        }
        return -1;
    }
}
