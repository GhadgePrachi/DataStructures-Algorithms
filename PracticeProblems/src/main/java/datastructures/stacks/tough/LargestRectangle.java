package datastructures.stacks.tough;

import java.util.ArrayList;
import java.util.Stack;

public class LargestRectangle {
    public int largestRectangleUnderSkyline(ArrayList<Integer> buildings) {
        Stack<Integer> increasingHeights = new Stack<>();
        int maxArea = 0, n = buildings.size();
        for (int i = 0; i < n; i++) {
            int currentHeight = buildings.get(i);
            while (!increasingHeights.isEmpty() && buildings.get(increasingHeights.peek()) >= currentHeight) {
                int heightIndex = increasingHeights.pop();
                int height = buildings.get(heightIndex);
                int rightIndex = i - 1;
                int leftIndex = increasingHeights.isEmpty() ? 0 : increasingHeights.peek() + 1;
                int width = rightIndex - leftIndex + 1;
                maxArea = Math.max(maxArea, width * height);
            }
            increasingHeights.push(i);
        }

        while (!increasingHeights.isEmpty()) {
            int heightIndex = increasingHeights.pop();
            int height = buildings.get(heightIndex);
            int rightIndex = n - 1;
            int leftIndex = increasingHeights.isEmpty() ? 0 : increasingHeights.peek() + 1;
            int width = rightIndex - leftIndex + 1;
            maxArea = Math.max(maxArea, width * height);
        }
        return maxArea;
    }
}
