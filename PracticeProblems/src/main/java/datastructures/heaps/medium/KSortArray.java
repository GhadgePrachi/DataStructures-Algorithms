package datastructures.heaps.medium;

import java.util.PriorityQueue;

public class KSortArray {
    public int[] sortKSortedArray(int[] array, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b)-> Integer.compare(a,b));
        int[] kSortedArray = new int[array.length];
        int kSortedIndex = -1;

        for (int i = 0; i < array.length; i++) {
            int currentElement = array[i];
            if (i > k) {
                int minElement = minHeap.poll();
                kSortedArray[++kSortedIndex] = minElement;
            }
            minHeap.offer(currentElement);
        }

        while (!minHeap.isEmpty()) {
            int minElement = minHeap.poll();
            kSortedArray[++kSortedIndex] = minElement;
        }

        return kSortedArray;
    }
}
