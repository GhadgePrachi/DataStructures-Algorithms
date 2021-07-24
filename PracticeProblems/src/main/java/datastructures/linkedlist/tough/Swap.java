package datastructures.linkedlist.tough;

public class Swap {
    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList nodeSwap(LinkedList list) {
        LinkedList node = list;
        while (node != null && node.next != null) {
            nodeSwap(node,node.next);
            node = node.next.next;
        }
        return list;
    }

    public void nodeSwap(LinkedList nodeOne, LinkedList nodeTwo) {
        int temp = nodeOne.value;
        nodeOne.value = nodeTwo.value;
        nodeTwo.value = temp;
    }
}