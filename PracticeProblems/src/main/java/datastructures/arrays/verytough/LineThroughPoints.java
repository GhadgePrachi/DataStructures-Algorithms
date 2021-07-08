package datastructures.arrays.verytough;

import java.util.HashMap;

public class LineThroughPoints {
    public int lineThroughPoints(int[][] points) {
        int maxNumberOfPointsOnLine = 1;

        for(int i = 0; i < points.length; i++) {
            int[] p = points[i];
            HashMap<String, Integer> slopes = new HashMap<>();
            for(int j = i + 1; j < points.length; j++) {
                int[]  q = points[j];
                int[] slope = getSlope(p,q);
                String slopeKey = String.valueOf(slope[0]) + ":" + String.valueOf(slope[1]);
                slopes.put(slopeKey, slopes.getOrDefault(slopeKey, 1) + 1);
                maxNumberOfPointsOnLine = Math.max(slopes.get(slopeKey), maxNumberOfPointsOnLine);
            }
        }
        return maxNumberOfPointsOnLine;
    }

    public static int[] getSlope(int[] p, int[] q) {
        int px = p[0];
        int py = p[1];
        int qx = q[0];
        int qy = q[1];

        int[] slope = new int[] {1,0};//vertical line
        if (px != qx) {
            int xDiff = px - qx;
            int yDiff = py - qy;
            int gcd = gcd(Math.abs(xDiff), Math.abs(yDiff));
            xDiff = xDiff / gcd;
            yDiff = yDiff / gcd;
            if (xDiff < 0) {
                xDiff *= -1;
                yDiff *= -1;
            }
            slope = new int[]{yDiff, xDiff};
        }
        return slope;
    }

    public static int gcd(int a, int b) {
        if (b == 0)
            return a;

        return gcd(b, a % b);
    }
}
