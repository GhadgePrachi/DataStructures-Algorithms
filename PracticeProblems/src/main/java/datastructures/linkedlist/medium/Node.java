package datastructures.linkedlist.medium;

public class Node {
    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

    /** Get Fractional Node **/
    public static LinkedList getKFactorial(LinkedList head, int k) {
        LinkedList fractionalNode = null;
        LinkedList current = head;
        int length = 0;

        while (current != null) {
            if (length % k == 0) {
                if (fractionalNode == null){
                    fractionalNode = current;
                } else {
                    fractionalNode = fractionalNode.next;
                }
            }
            length++;
            current = current.next;
        }
        return fractionalNode;
    }

    /** Get Modular Node **/
    public static LinkedList getKModularNodeFromStart(LinkedList head, int k){
        LinkedList modularNode = null;
        LinkedList current = head;
        int length = 0;

        while (current!=null) {
            if (length % k == 0) {
                modularNode = current;
            }
            length++;
            current = current.next;
        }
        return  modularNode;
    }

    /** Get Kth Node from end **/
    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        LinkedList first = head;
        LinkedList second = head;
        int K = k;
        while (first != null && K > 0) {
            first = first.next;
            K -= 1;
        }

        if (first == null) {
            head.value = head.next.value;
            head.next = head.next.next;
            return;
        }

        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
    }
}