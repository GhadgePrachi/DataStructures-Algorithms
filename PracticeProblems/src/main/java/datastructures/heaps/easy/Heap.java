package datastructures.heaps.easy;

import java.util.List;

public class Heap {
    static class MinHeap {
        List<Integer> heap;

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        public List<Integer> buildHeap(List<Integer> array) {
            int lastElementIndex = array.size() - 1;
            int firstParentIndex = (lastElementIndex - 1)/2;
            for (int i = firstParentIndex; i >= 0; i--) {
                siftDown(i, array.size(), array);
            }
            return array;
        }

        public void siftDown(int currentIndex, int endIndex, List<Integer> heap) {
            int indexToSwap = currentIndex; // Initialize smallest as root
            int leftIndex = 2 * currentIndex + 1; // leftIndex = 2*i + 1
            int rightIndex = 2 * currentIndex + 2; // rightIndex = 2*i + 2
            if (leftIndex < endIndex && heap.get(leftIndex) < heap.get(indexToSwap)) {
                indexToSwap = leftIndex;
            }
            if (rightIndex < endIndex && heap.get(rightIndex) < heap.get(indexToSwap)) {
                indexToSwap = rightIndex;
            }
            if (indexToSwap != currentIndex) {
                swap(heap, currentIndex, indexToSwap);
                siftDown(indexToSwap, endIndex, heap);
            }
        }

        public void siftUp(int currentIndex, List<Integer> heap) {
            int parentIndex = (currentIndex - 1)/2;
            if (currentIndex > 0 && heap.get(currentIndex) < heap.get(parentIndex)) {
                swap(heap, currentIndex, parentIndex);
                siftUp(parentIndex, heap);
            }
        }

        public int peek() {
            return heap.get(0);
        }

        public int remove() {
            int value = heap.get(0);
            swap(heap, 0, heap.size() -1);
            heap.remove(heap.size() - 1);
            siftDown(0, heap.size() - 1, heap);
            return value;
        }

        public void insert(int value) {
            heap.add(value);
            siftUp(heap.size() - 1, heap);
        }

        public static void swap(List<Integer> a, int i, int j) {
            int temp = a.get(i);
            a.set(i, a.get(j));
            a.set(j, temp);
        }
    }
}
