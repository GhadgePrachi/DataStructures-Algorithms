package algorithms.searching.verytough;

import java.util.Arrays;

public class BinarySearchKthSmallestPairDistance {
    public int kthSmallestPairDistance(int[] array, int k) {
        Arrays.sort(array);
        int left = 0, right = array[array.length - 1] - array[0];
        while (left <= right) {
            int mid = (left + right) / 2;
            //count => number of pairs of elements with distance <= mi
            int count = count(array, mid);
            if(count < k) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return left;
    }

    private int count(int[] array, int target){
        int count = 0;
        int left = 0, right = 0;
        for (right = 0; right < array.length; right++) {
            while (array[right] - array[left] > target) {
                left++;
            }
            count += right - left;
        }
        return count;
    }

}
