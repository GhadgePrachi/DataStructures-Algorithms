package datastructures.linkedlist.medium;

public class Sum {
    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    /** Sum from Left - Right **/
    public LinkedList sumOfLinkedLists(LinkedList listOne, LinkedList listTwo) {
        int carry = 0, val = 0;
        LinkedList list = null, head = null;

        while (listOne != null || listTwo != null || carry != 0) {
            int sum = (listOne == null ? 0 : listOne.value) + (listTwo == null ? 0 : listTwo.value) + carry;
            val = sum % 10;
            carry = sum / 10;
            LinkedList current = new LinkedList(val);

            if (list != null) {
                list.next = current;
            }
            list = current;

            if (head == null) {
                head = current;
            }

            if (listOne != null) {
                listOne = listOne.next;
            }

            if (listTwo != null) {
                listTwo = listTwo.next;
            }
        }
        return head;
    }

    /** Sum from Right - Left **/
    private static LinkedList addLists(LinkedList listOne, LinkedList listTwo) {
        int lengthOne = length(listOne);
        int lengthTwo = length(listTwo);
        if (lengthOne < lengthTwo) {
            listOne = padList(listOne, lengthTwo - lengthOne);
        } else {
            listTwo = padList(listTwo, lengthOne - lengthTwo);
        }
        PartialSum sum = addListsHelper(listOne, listTwo);
        if (sum.carry == 0) {
            return sum.sum;
        } else {
            LinkedList result = insertBefore(sum.sum, sum.carry);
            return result;
        }
    }

    private static LinkedList padList(LinkedList list, int padding) {
        LinkedList head = list;
        for (int i = 0; i < padding; i++) {
            head = insertBefore(head, 0);
        }
        return head;
    }

    private static LinkedList insertBefore(LinkedList list, int data) {
        LinkedList node = new LinkedList(data);
        if (list != null) {
            node.next = list;
        }
        return node;
    }

    private static PartialSum addListsHelper(LinkedList listOne, LinkedList listTwo) {
        if (listOne == null && listTwo == null) {
            PartialSum sum = new PartialSum();
            return sum;
        }
        PartialSum sum = addListsHelper(listOne.next, listTwo.next);

        int val = sum.carry + listOne.value + listTwo.value;
        LinkedList result = insertBefore(sum.sum, val % 10);
        sum.sum = result;
        sum.carry = val / 10;
        return sum;
    }

    private static int length(LinkedList list) {
        if (list == null) {
            return 0;
        } else {
            return 1 + length(list.next);
        }
    }

    public static class PartialSum {
        public LinkedList sum = null;
        public int carry = 0;
    }
}