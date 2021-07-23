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

    public static LinkedList findIntersection(LinkedList listOne, LinkedList listTwo) {
        if (listOne == null || listTwo == null) {
            return null;
        }

        Result resultOne = getTailAndSize(listOne);
        Result resultTwo = getTailAndSize(listTwo);
        if (resultOne.tail != resultTwo.tail) {
            return null;
        }

        LinkedList shorter = resultOne.size < resultTwo.size ? listOne : listTwo;
        LinkedList longer = resultOne.size < resultTwo.size ? listTwo : listOne;

        longer = getKthNode(longer, Math.abs(resultOne.size - resultTwo.size));

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

    public static LinkedList getKthNode(LinkedList list, int k) {
        LinkedList current = list;
        while (k > 0 && current != null) {
            current = current.next;
            k--;
        }
        return current;
    }
}