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

    public LinkedList nodeSwap(LinkedList head) {
        LinkedList node = head;
        while (node != null && node.next != null) {
            nodeSwap(node,node.next);
            node = node.next.next;
        }
        return head;
    }

    public void nodeSwap(LinkedList node1, LinkedList node2) {
        int temp = node1.value;
        node1.value = node2.value;
        node2.value = temp;
    }
}
