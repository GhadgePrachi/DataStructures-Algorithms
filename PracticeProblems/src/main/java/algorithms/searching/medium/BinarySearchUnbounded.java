package algorithms.searching.medium;

public class BinarySearchUnbounded {
    public static int unboundedSearch(Listy list, int target){
        int index = 1;
        while(list.elementAt(index) != -1 && list.elementAt(index) < target) {
            index *=2;
        }

        int left = index/2, right = index;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = list.elementAt(mid);
            if (midValue > target || midValue == -1) {
                right = mid - 1;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

     static class Listy {
        int[] array;

        public Listy(int[] arr) {
            array = arr.clone();
        }

        public int elementAt(int index) {
            if (index >= array.length) {
                return -1;
            }
            return array[index];
        }
    }
}
