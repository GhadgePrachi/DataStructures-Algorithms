package algorithms.dynamicprogramming.tough;

public class WaterArea {
    public static int waterArea(int[] heights) {
        int[] leftMaxes = new int[heights.length];
        int leftMax = 0;
        for (int i = 0; i < heights.length; i++) {
            leftMax = Math.max(leftMax, heights[i]);
            leftMaxes[i] = leftMax;
        }

        int totalVolume = 0;
        int rightMax = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            rightMax = Math.max(rightMax, heights[i]);
            int secondTallest = Math.min(rightMax, leftMaxes[i]);

            if (secondTallest > heights[i]) {
                totalVolume += secondTallest - heights[i];
            }
        }
        return totalVolume;
    }
}
