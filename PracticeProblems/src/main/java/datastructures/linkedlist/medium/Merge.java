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

    public static LinkedList merge(LinkedList listOne, LinkedList listTwo) {
        LinkedList current, head = null, list = null;

        while (listOne != null && listTwo != null) {
            if (listOne.value < listTwo.value) {
                current = listOne;
                listOne = listOne.next;
            } else {
                current = listTwo;
                listTwo = listTwo.next;
            }

            if (list != null) {
                list.next = current;
            }
            list = current;

            if (head == null) {
                head = current;
            }
        }

        if (listOne != null) {
            list.next = listOne;
        }

        if (listTwo != null) {
            list.next = listTwo;
        }
        return head;
    }
}