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

    public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        int carry = 0, val = 0;
        LinkedList list = null, head = null;

        while (linkedListOne != null || linkedListTwo != null || carry != 0) {
            int sum = (linkedListOne == null ? 0 : linkedListOne.value) +
                    (linkedListTwo == null ? 0 : linkedListTwo.value) +
                    carry;
            val = sum % 10;
            carry = sum / 10;
            LinkedList current = new LinkedList(val);

            if (list != null) {
                list.next = current;
            }
            list = current;

            if (head == null)
                head = current;

            if (linkedListOne != null)
                linkedListOne = linkedListOne.next;

            if (linkedListTwo != null)
                linkedListTwo = linkedListTwo.next;

        }

        return head;
    }
}
