package datastructures.linkedlist.tough;

public class Reverse {
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList reverseLinkedList(LinkedList head) {
        LinkedList current = head;
        LinkedList previous = null;
        while (current != null) {
            LinkedList next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}
