package datastructures.linkedlist.medium;

public class Merge {
    static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
        LinkedList current = null, head = null, list = null;

        while (headOne != null && headTwo != null) {
            if (headOne.value < headTwo.value) {
                current = headOne;
                headOne = headOne.next;
            } else {
                current = headTwo;
                headTwo = headTwo.next;
            }

            if (list != null) {
                list.next = current;
            }
            list = current;

            if (head == null) {
                head = current;
            }
        }

        if (headOne != null)
            list.next = headOne;

        if (headTwo != null)
            list.next = headTwo;

        return head;
    }
}
