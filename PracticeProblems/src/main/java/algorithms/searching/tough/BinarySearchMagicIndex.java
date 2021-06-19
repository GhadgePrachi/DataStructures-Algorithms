package algorithms.searching.tough;

public class BinarySearchMagicIndex {
    //Assumption 1 : Only one solution with no duplicates

    //Assumption 2 : Only one solution with duplicates
    public int indexEqualsValue(int[] array){
        return indexEqualsValue(array, 0, array.length - 1);
    }

    public int indexEqualsValue(int[] array,int left, int right){
        if (left > right) {
            return -1;
        }

        int midIndex = left + (right-left)/2;
        int midValue = array[midIndex];
        if (midValue == midIndex) {
            return midIndex;
        }

        int leftIndex = Math.min(midIndex - 1, midValue);
        int leftValue = indexEqualsValue(array, left, leftIndex);
        if(leftValue >= 0) {
            return leftValue;
        }

        int rightIndex = Math.max(midIndex + 1, midValue);
        return indexEqualsValue(array, rightIndex, right);
    }

    //Assumption 3 : Multiple solutions with no duplicates, return first
    public int indexEqualsValue2(int[] array) {
        int left = 0, right = array.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            int midValue = array[mid];

            if ((midValue == mid && mid == 0) || (midValue == mid && array[mid - 1] < mid - 1)) {
                return midValue;
            } else  if (midValue < mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
