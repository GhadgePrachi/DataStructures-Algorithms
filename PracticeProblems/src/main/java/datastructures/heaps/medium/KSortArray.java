package datastructures.heaps.medium;

import java.util.PriorityQueue;

public class KSortArray {
    public int[] sortKSortedArray(int[] array, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b)-> Integer.compare(a,b));
        int[] kSortedArray = new int[array.length];
        int kSortedIndex = -1;

        int i = 0;
        while (i <= k) {
            int currentElement = array[i];
            minHeap.offer(currentElement);
            i++;
        }
        while (i < array.length){
            int currentElement = array[i];
            int minElement = minHeap.poll();
            kSortedArray[++kSortedIndex] = minElement;
            minHeap.offer(currentElement);
            i++;
        }
        while (!minHeap.isEmpty()) {
            int minElement = minHeap.poll();
            kSortedArray[++kSortedIndex] = minElement;
        }
        return kSortedArray;
    }
}
