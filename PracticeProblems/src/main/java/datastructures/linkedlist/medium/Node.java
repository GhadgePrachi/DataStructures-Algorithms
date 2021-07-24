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
    public static LinkedList getKFactorial(LinkedList list, int k) {
        LinkedList current = list;
        LinkedList fractionalNode = null;
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
    public static LinkedList getKModularNodeFromStart(LinkedList list, int k){
        LinkedList current = list;
        LinkedList modularNode = null;
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

    /** Get Kth Node from start **/
    public static LinkedList getKthNodeFromStart(LinkedList list, int k) {
        LinkedList current = list;
        while (k > 0 && current != null) {
            current = current.next;
            k--;
        }
        return current;
    }

    /** Get Kth Node from end **/
    public static LinkedList removeKthNodeFromEnd(LinkedList list, int k) {
        LinkedList first = list;
        LinkedList second = list;
        int K = 1;
        while (first != null && K < k) {
            first = first.next;
            K++;
        }

        if (first == null) {
            return first;
        }

        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }
}