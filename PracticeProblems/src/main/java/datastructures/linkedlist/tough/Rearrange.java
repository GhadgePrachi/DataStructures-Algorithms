package datastructures.linkedlist.tough;

import datastructures.linkedlist.medium.Intersection;

public class Rearrange {
    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            next = null;
        }
    }

    /** Rearrange by k **/
    public static LinkedList rearrange(LinkedList list, int k) {
        LinkedList smallerHead = null, smallerTail = null;
        LinkedList greaterHead = null, greaterTail = null;
        LinkedList equalHead = null, equalTail = null;
        LinkedList current = list;

        while (current != null) {
            LinkedList next = current.next;
            current.next = null;
            if (current.value < k) {
                if (smallerHead == null) {
                    smallerHead = current;
                    smallerTail = smallerHead;
                } else {
                    smallerTail.next = current;
                    smallerTail = current;
                }
            } else if (current.value > k) {
                if (greaterHead == null) {
                    greaterHead = current;
                    greaterTail = greaterHead;
                } else {
                    greaterTail.next = current;
                    greaterTail = current;
                }
            } else {
                if (equalHead == null) {
                    equalHead = current;
                    equalTail = equalHead;
                } else {
                    equalTail.next = current;
                    equalTail = current;
                }
            }
            current = next;
        }

        LinkedListPair firstPair = connect(smallerHead, smallerTail, equalHead, equalTail);
        LinkedListPair secondPair = connect(firstPair.head, firstPair.tail, greaterHead, greaterTail);
        return secondPair.head;
    }

    public static LinkedListPair connect(LinkedList headOne, LinkedList tailOne, LinkedList headTwo, LinkedList tailTwo) {
        LinkedList newHead = (headOne == null ? headTwo : headOne);
        LinkedList newTail = (tailTwo == null ? tailOne : tailTwo);

        if (tailOne != null) {
            tailOne.next = headTwo;
        }
        return new LinkedListPair(newHead, newTail);
    }

    static class LinkedListPair {
        LinkedList head;
        LinkedList tail;

        public LinkedListPair(LinkedList head, LinkedList tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    /** Shift By k **/
    public static LinkedList shift(LinkedList list, int k) {
        int length = 1;
        LinkedList tail = list;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        int offset = Math.abs(k) % length;
        if (offset == 0) {
            return list;
        }
        int newOffset = k > 0 ? length - offset : offset;
        LinkedList current = list;
        while (newOffset > 1) {
            current = current.next;
            newOffset--;
        }

        LinkedList newHead = current.next;
        current.next = null;
        tail.next = list;
        return newHead;
    }

    /** Rearrange into two **/
    public void splitIntoTwo(LinkedList head, LinkedList headOne,LinkedList headTwo){
        LinkedList fast = head;
        LinkedList slow = head;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        headOne = head;
        headTwo = slow.next;

        slow.next = headOne;
        fast.next = headTwo;
    }

    /** Rearrange by odd-even **/
    public LinkedList alternateOddEven(LinkedList list) {
        if (list == null || list.next == null) {
            return list;
        }

        LinkedList odd = list, even = list.next, evenHead = even;
        while (odd!=null && even!=null && odd.next != null && even.next != null ) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return list;
    }
}