package datastructures.heaps.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KSortedArrays {
    public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
        List<Integer> sortedList = new ArrayList<>();
        PriorityQueue<Item> minHeap = new PriorityQueue<>((a, b)->Integer.compare(a.num,b.num));
        for (int i = 0; i < arrays.size(); i++) {
            minHeap.offer(new Item(i, 0, arrays.get(i).get(0)));
        }

        while(!minHeap.isEmpty()) {
            Item item = minHeap.poll();
            sortedList.add(item.num);
            if (item.elementIndex < arrays.get(item.arrayIndex).size() - 1) {
                minHeap.offer(new Item(item.arrayIndex, item.elementIndex + 1, arrays.get(item.arrayIndex).get(item.elementIndex + 1)));
            }
        }
        return sortedList;
    }

    static class Item {
        int num;
        int arrayIndex;
        int elementIndex;

        public Item (int arrayIndex, int elementIndex, int num) {
            this.arrayIndex = arrayIndex;
            this.elementIndex = elementIndex;
            this.num = num;
        }
    }
}
