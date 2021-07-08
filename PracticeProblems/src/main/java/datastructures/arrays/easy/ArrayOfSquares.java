package datastructures.arrays.easy;

public class ArrayOfSquares {
    public int[] sortedSquaredArray(int[] array) {
        int[] squared = new int[array.length];
        int n = array.length;
        int i = n-1;
        int left = 0, right = n-1;
        while(left <= right){
            if (array[left] * array[left] >= array[right] * array[right]){
                squared[i--] = array[left]*array[left];
                left++;
            } else {
                squared[i--] = array[right]*array[right];
                right--;
            }
        }
        return squared;
    }
}
