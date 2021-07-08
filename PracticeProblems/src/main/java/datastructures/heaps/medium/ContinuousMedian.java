package datastructures.heaps.medium;

import java.util.Collections;
import java.util.PriorityQueue;

public class ContinuousMedian {
    static class ContinuousMedianHandler {
        double median = 0;
        private static PriorityQueue<Integer> maxHeap;
        private static PriorityQueue<Integer> minHeap;

        public ContinuousMedianHandler() {
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            minHeap = new PriorityQueue<>((a,b)->Integer.compare(a,b));
        }

        public void insert(int number) {
            if (maxHeap.size() == minHeap.size()) {
                if ((minHeap.peek() != null) &&
                        number > minHeap.peek()) {
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(number);
                } else {
                    maxHeap.offer(number);
                }
            }
            else {
                if(number < maxHeap.peek()){
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(number);
                }
                else {
                    minHeap.offer(number);
                }
            }
        }

        public double getMedian() {
            if (maxHeap.isEmpty()) {
                return 0;
            }
            if (maxHeap.size() == minHeap.size()) {
                return ((double)minHeap.peek() + (double) maxHeap.peek()) / 2;
            } else {
                return maxHeap.peek();
            }
        }
    }
}
