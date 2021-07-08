package datastructures.arrays.medium;

import java.util.HashSet;

public class SubsetRange {
    public static int[] largestRange(int[] array) {
        int[] longestRange = new int[2];
        HashSet<Integer> uniqueElements = new HashSet<>();

        for (int val : array) {
            uniqueElements.add(val);
        }

        for(int val : array){
            if (uniqueElements.contains(val-1)) {
                continue;
            }

            int start = val, end = val;
            while(uniqueElements.contains(end)){
                end += 1;
            }
            end -= 1;

            if (longestRange[1] - longestRange[0] <= end - start){
                longestRange = new int[] {start, end};
            }
        }
        return longestRange;
    }
}
