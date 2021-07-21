package datastructures.linkedlist.medium;

public class Cycle {
    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

    /** Find Loop **/
    public static LinkedList findLoop(LinkedList head) {
        LinkedList slow = head;
        LinkedList fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow)
                break;
        }

        if (fast == null || fast.next == null)
            return null;

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /** Find Loop start **/
    public LinkedList getCycleStart(LinkedList head){
        LinkedList fast = head,slow = head;

        while (fast == null || fast.next == null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
