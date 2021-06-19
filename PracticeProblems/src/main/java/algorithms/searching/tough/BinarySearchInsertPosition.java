package algorithms.searching.tough;

import java.util.Arrays;

public class BinarySearchInsertPosition {
    public int searchInsert(int[] array, int target) {
        int left = 0, right = array.length-1;
        while (left <= right) {
            int mid =  left + ((right - left)/2);

            if(array[mid]<target) {
                left = mid+1;
            }
            else if(array[mid]>target) {
                right = mid-1;
            }
            else if(array[mid]==target) {
                return mid;
            }
        }
        return left;
    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int maxRadius = Integer.MIN_VALUE;

        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);//returns (-(insertion point) – 1) instead of -1
            if (index < 0) {
                index = ~index;//-(index + 1)
            }
            int distanceOne = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
            int distanceTwo = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
            maxRadius = Math.max(maxRadius, Math.min(distanceOne, distanceTwo));
        }
        return maxRadius;
    }
}
