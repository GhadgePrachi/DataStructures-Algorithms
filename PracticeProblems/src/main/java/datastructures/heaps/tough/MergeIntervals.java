package datastructures.heaps.tough;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {
    public int[][] mergeOverlappingIntervals(int[][] intervals) {
        int[][] clonedIntervals = intervals.clone();
        Arrays.sort(clonedIntervals, (a, b)->Integer.compare(a[0],b[0]));

        LinkedList<int[]> mergedIntervals = new LinkedList<>();
        for (int[] interval : clonedIntervals){
            if (mergedIntervals.isEmpty() || mergedIntervals.getLast()[1] < interval[0]){
                mergedIntervals.add(interval);
            } else {
                mergedIntervals.getLast()[1] = Math.max(mergedIntervals.getLast()[1], interval[1]);
            }
        }
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
