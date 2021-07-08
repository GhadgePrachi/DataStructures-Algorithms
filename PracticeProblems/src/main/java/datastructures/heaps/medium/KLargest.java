package datastructures.heaps.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KLargest {
    public static int LARGEST_COUNT = 3;
    public static int[] findThreeLargestNumbers(int[] array) {
        int[] threeLargest = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int num : array) {
            updateLargest(num, threeLargest);
        }
        return threeLargest;
    }

    public static void updateLargest(int num, int[] threeLargest) {
        if (threeLargest[2] < num) {
            shiftUpdate(threeLargest, num, 2);
        } else if (threeLargest[1] < num) {
            shiftUpdate(threeLargest, num, 1);
        } else if (threeLargest[0] < num) {
            shiftUpdate(threeLargest, num, 0);
        }
    }

    public static void shiftUpdate(int[] threeLargest, int num, int index) {
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                threeLargest[index] = num;
            } else {
                threeLargest[i] = threeLargest[i+1];
            }
        }
    }

    public static List<Integer> findKLargestNumbers(List<Integer> array) {
        PriorityQueue<Integer> sortedQueue = new PriorityQueue<>();
        for (int element : array) {
            sortedQueue.offer(element);
            if (sortedQueue.size() == LARGEST_COUNT + 1) {
                sortedQueue.poll();
            }
        }

        List<Integer> largest = new ArrayList<>();
        while (!sortedQueue.isEmpty()) {
            int num = sortedQueue.poll();
            largest.add(num);
        }
        return largest;
    }
}
