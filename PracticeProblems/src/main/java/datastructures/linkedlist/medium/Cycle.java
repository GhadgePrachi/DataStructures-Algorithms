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
    public static LinkedList findLoop(LinkedList list) {
        LinkedList slow = list;
        LinkedList fast = list;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow)
                break;
        }

        if (fast == null || fast.next == null)
            return null;

        slow = list;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /** Find Loop start **/
    public LinkedList getCycleStart(LinkedList list){
        LinkedList fast = list, slow = list;

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

        slow = list;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    /** Find Loop length **/
    public int getCycleLength(LinkedList list){
        LinkedList fast = list, slow = list;

        while (fast == null || fast.next == null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                break;
            }
        }

        int cycleLength = 0;
        if (fast == null || fast.next == null) {
            return cycleLength;
        }

        do {
            slow = slow.next;
            cycleLength++;
        } while (slow != fast);
        return cycleLength;
    }
}