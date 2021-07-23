package datastructures.linkedlist.medium;

import java.util.HashSet;

public class Duplicates {
     static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList removeDuplicatesFromLinkedList(LinkedList list) {
        HashSet<Integer> uniqueElements = new HashSet<>();
        uniqueElements.add(list.value);
        LinkedList current = list;
        while (current.next != null) {
            if (uniqueElements.contains(current.next.value)) {
                current.next = current.next.next;
            } else {
                uniqueElements.add(current.next.value);
                current = current.next;
            }
        }
        return list;
    }
}
