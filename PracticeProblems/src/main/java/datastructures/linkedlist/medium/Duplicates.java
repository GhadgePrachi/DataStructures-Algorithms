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

    public LinkedList removeDuplicates(LinkedList list) {
        HashSet<Integer> uniqueElements = new HashSet<>();
        LinkedList current = list;
        LinkedList prev = null;
        while (current != null) {
            if (uniqueElements.contains(current.value)) {
                prev.next = current.next;
            } else {
                uniqueElements.add(current.value);
                prev = current;
            }
            current = current.next;
        }
        return list;
    }
}