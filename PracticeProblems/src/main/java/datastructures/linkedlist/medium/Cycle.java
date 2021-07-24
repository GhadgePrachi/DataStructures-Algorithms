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
        return slow;
    }

    /** Find Loop length **/
    public int findLoopLength(LinkedList list){
        LinkedList fast = list, slow = list;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        int loopLength = 0;
        if (fast == null || fast.next == null) {
            return loopLength;
        }
        do {
            slow = slow.next;
            loopLength++;
        } while (slow != fast);
        return loopLength;
    }
}