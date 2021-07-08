package datastructures.heaps.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KPairSmallestSum {
    public List<int[]> kSmallestPairs(int[] arrayOne, int[] arrayTwo, int k) {
        PriorityQueue<Item> minHeap = new PriorityQueue<>((a,b) -> Long.compare(a.sum, b.sum));
        List<int[]> kSmallestPairs = new ArrayList<>();
        for (int i = 0; i < arrayOne.length; i++) {
            minHeap.offer( new Item(0, arrayOne[i],arrayTwo[0]) );
        }
        while (k > 0) {
            Item pair = minHeap.poll();
            kSmallestPairs.add(pair.pair);
            if (pair.indexTwo < arrayTwo.length - 1) {
                int next = pair.indexTwo + 1;
                minHeap.offer( new Item(next, pair.pair[0], arrayTwo[next]) );
            }
            k--;
        }
        return kSmallestPairs;
    }

    static class Item{
        long sum;
        int[] pair;
        int indexTwo;
        Item(int idx, int n1, int n2){
            this.indexTwo = idx;
            pair = new int[]{n1, n2};
            sum = (long) n1 + (long) n2;
        }
    }
}
