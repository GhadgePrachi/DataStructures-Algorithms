package datastructures.heaps.tough;

import java.util.LinkedList;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> result = new LinkedList<>();
        int size = 0, i = 0, n = intervals.length;
        boolean addedInterval = false;

        //Before the overlap
        while (i < n && !isOverLap(intervals[i],newInterval)) {
            if (!addedInterval && newInterval[1]<intervals[i][0]) {
                result.add(newInterval);
                addedInterval = true;
                size++;
            }
            result.add(intervals[i]);
            size++;
            i++;
        }

        //When overlap
        while (i < n && isOverLap(intervals[i],newInterval)) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        if (!addedInterval) {
            result.add(newInterval);
            size++;
        }

        //After overlap
        while (i < n) {
            result.add(intervals[i]);
            size++;
            i++;
        }
        return result.toArray(new int[size][]);
    }

    public boolean isOverLap(int[] i1, int[] i2){
        if (i1[0]>i2[1] || i2[0]>i1[1])
            return false;
        else
            return true;
    }
}
