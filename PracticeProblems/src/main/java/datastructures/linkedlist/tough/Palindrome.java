package datastructures.linkedlist.tough;

public class Palindrome {
    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public boolean linkedListPalindrome(LinkedList head) {
        LinkedList fast = head;
        LinkedList slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null)
            slow = slow.next;//ignore odd middle

        LinkedList reverse = reverseLinkedList(slow);
        LinkedList current = head;

        while (reverse != null) {
            if (reverse.value != current.value)
                return false;
            reverse = reverse.next;
            current = current.next;
        }
        return true;
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
