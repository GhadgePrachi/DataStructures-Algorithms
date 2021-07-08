package datastructures.arrays.medium;

public class SubarraySort {
    public static int[] subarraySort(int[] array) {
        int endLeft = findEndOfLeftSubsequence(array);
        if (endLeft >= array.length - 1) {
            return new int[]{-1,-1};
        }
        int startRight = findStartOfRightSubsequence(array);

        int[] indices = getMinMax(array, endLeft, startRight);
        int minIndex = indices[0];
        int maxIndex = indices[1];
        
        int subArrayLeft = shrinkLeft(array,minIndex,0);
        int subArrayRight = shrinkRight(array,maxIndex,array.length-1);
        return new int[]{subArrayLeft,subArrayRight};
    }

    public static int findEndOfLeftSubsequence(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return i - 1;
            }
        }
        return array.length - 1;
    }

    public static int findStartOfRightSubsequence(int[] array) {
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] > array[i + 1]) {
                return i + 1;
            }
        }
        return 0;
    }

    public static int shrinkLeft(int[] array, int minIndex, int subArrayLeft) {
        while(array[subArrayLeft] <= array[minIndex]){
            subArrayLeft += 1;
        }
        return subArrayLeft;
    }

    public static int shrinkRight(int[] array, int maxIndex, int subArrayRight) {
        while(array[subArrayRight] >= array[maxIndex]){
            subArrayRight -= 1;
        }
        return subArrayRight;
    }

    public static int[] getMinMax(int[] array, int start, int end){
        int maxIndex = start;
        int minIndex = end;
        for (int i = start+1; i < end; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
        }
        return new int[]{minIndex, maxIndex};
    }
}
