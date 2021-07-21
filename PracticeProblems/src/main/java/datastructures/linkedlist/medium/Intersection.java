package datastructures.linkedlist.medium;

public class Intersection {
    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    static class Result {
        public LinkedList tail;
        public int size;
        public Result(LinkedList tail, int size) {
            this.tail = tail;
            this.size = size;
        }
    }

    public static LinkedList findIntersection(LinkedList list1, LinkedList list2) {
        if (list1 == null || list2 == null) {
            return null;
        }

        Result result1 = getTailAndSize(list1);
        Result result2 = getTailAndSize(list2);
        if (result1.tail != result2.tail) {
            return null;
        }

        LinkedList shorter = result1.size < result2.size ? list1 : list2;
        LinkedList longer = result1.size < result2.size ? list2 : list1;

        longer = getKthNode(longer, Math.abs(result1.size - result2.size));

        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }

        return longer;
    }

    public static Result getTailAndSize(LinkedList list) {
        if (list == null) return null;

        int size = 1;
        LinkedList current = list;
        while (current.next != null) {
            size++;
            current = current.next;
        }
        return new Result(current, size);
    }

    public static LinkedList getKthNode(LinkedList head, int k) {
        LinkedList current = head;
        while (k > 0 && current != null) {
            current = current.next;
            k--;
        }
        return current;
    }
}
