package datastructures.stacks.tough;

import java.util.ArrayList;
import java.util.Stack;

public class LargestRectangle {
    public int largestRectangleUnderSkyline(ArrayList<Integer> buildings) {
        Stack<Integer> increasingHeights = new Stack<>();
        increasingHeights.push(-1);
        int maxArea = 0, n = buildings.size();

        for (int i = 0; i < n; i++) {
            int currentHeight = buildings.get(i);

            while (increasingHeights.peek() != -1 &&
                    buildings.get(increasingHeights.peek()) >= currentHeight) {
                int leftIndex = increasingHeights.pop();
                int width = i - 1 - increasingHeights.peek();
                int height = buildings.get(leftIndex);
                maxArea = Math.max(maxArea, width * height);
            }
            increasingHeights.push(i);
        }

        while (increasingHeights.peek() != -1) {
            int index = increasingHeights.pop();
            int width = n - 1 - increasingHeights.peek();
            int height = buildings.get(index);
            maxArea = Math.max(maxArea, width * height);
        }
        return maxArea;
    }
}
