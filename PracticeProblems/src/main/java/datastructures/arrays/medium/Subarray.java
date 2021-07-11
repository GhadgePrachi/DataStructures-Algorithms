package datastructures.arrays.medium;

import java.util.HashMap;

public class Subarray {
    /** Max Sum SubArray : Kadane's Algorithm **/
    public int maxSubArray(int[] array) {
        int runningSum = 0, maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            runningSum = Math.max(array[i], runningSum + array[i]);
            maxSum = Math.max(maxSum, runningSum);
        }
        return maxSum;
    }

    /** SubArray Sum k **/
    public int subArraySum(int[] array, int k) {
        int count = 0, runningSum = 0;
        HashMap <Integer, Integer> map = new HashMap <>();
        for (int i = 0; i < array.length; i++) {
            runningSum += array[i];
            if (runningSum == k) {
                count += 1;
            }
            if (map.containsKey(runningSum - k)) {
                count += map.get(runningSum - k);
            }
            map.put(runningSum, map.getOrDefault(runningSum, 0) + 1);
        }
        return count;
    }

    /** SubArray Maximum 1's by flipping maximum k 0's **/
    public int longestOnes(int[] array, int k) {
        int left = 0, right;
        for (right = 0; right < array.length; right++) {
            if (array[right] == 0) {
                k--;
            }

            if (k < 0) {
                if (array[left] == 0) {
                    k++;
                }
                left++;
            }
        }
        return right - left;
    }

    /** SubArray Sort **/
    public static int[] subArraySort(int[] array) {
        int endLeft = findEndOfLeftSubsequence(array);
        if (endLeft >= array.length - 1) {
            return new int[] {-1,-1};
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
            subArrayLeft++;
        }
        return subArrayLeft;
    }

    public static int shrinkRight(int[] array, int maxIndex, int subArrayRight) {
        while(array[subArrayRight] >= array[maxIndex]){
            subArrayRight--;
        }
        return subArrayRight;
    }

    public static int[] getMinMax(int[] array, int start, int end) {
        int maxIndex = start;
        int minIndex = end;
        for (int i = start + 1; i < end; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
        }
        return new int[] {minIndex, maxIndex};
    }
}
