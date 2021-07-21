package datastructures.arrays.verytough;

import java.util.HashMap;

public class LineThroughPoints {
    public int lineThroughPoints(int[][] points) {
        int maxNumberOfPointsOnLine = 1;

        for(int i = 0; i < points.length - 1; i++) {
            int[] p = points[i];
            HashMap<String, Integer> slopes = new HashMap<>();
            for(int j = i + 1; j < points.length; j++) {
                int[]  q = points[j];
                int[] slope = getSlope(p,q);
                String slopeKey = slope[0] + ":" + slope[1];
                slopes.put(slopeKey, slopes.getOrDefault(slopeKey, 1) + 1);
                maxNumberOfPointsOnLine = Math.max(slopes.get(slopeKey), maxNumberOfPointsOnLine);
            }
        }
        return maxNumberOfPointsOnLine;
    }

    public static int[] getSlope(int[] p, int[] q) {
        int[] slope = new int[] {1,0};//vertical line
        int px = p[0], py = p[1], qx = q[0], qy = q[1];

        if (px != qx) {
            int xDiff = px - qx;
            int yDiff = py - qy;
            int gcd = BasicMath.gcd(Math.abs(xDiff), Math.abs(yDiff));
            xDiff = xDiff / gcd;
            yDiff = yDiff / gcd;
            if (yDiff < 0) {
                xDiff *= -1;
                yDiff *= -1;
            }
            slope = new int[]{yDiff, xDiff};
        }
        return slope;
    }
}
