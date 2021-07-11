package datastructures.arrays.verytough;

import java.util.HashSet;
import java.util.Set;

public class RectangleMinimumArea {
    public int minimumAreaRectangle(int[][] points) {
        Set<String> seen = new HashSet<>();
        for(int[] p : points) {
            seen.add(p[0] + ":" + p[1]);
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < points.length; i++) {
            int[] p = points[i];
            for(int j = 0; j < points.length; j++) {
                int[]  q = points[j];
                if(q[0] > p[0] && q[1] > p[1]) {
                    if(seen.contains(p[0]+ ":" + q[1]) && seen.contains(q[0]+ ":" + p[1])) {
                        //Condition to check if the opposite diagonal points are present in the input points.
                        min = Math.min(min, Math.abs((q[1] - p[1]) * (q[0] - p[0])));
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
