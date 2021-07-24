package datastructures.linkedlist.easy;

public class LinkedList {
    static class DoublyLinkedListNode {
        public int value;
        public DoublyLinkedListNode prev;
        public DoublyLinkedListNode next;

        public DoublyLinkedListNode(int value) {
            this.value = value;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public void setHead(DoublyLinkedListNode node) {
            if (head == null) {
                head = node;
                tail = node;
                return;
            }
            insertBefore(head, node);
        }

        public void setTail(DoublyLinkedListNode node) {
            if (tail == null) {
                setHead(node);
                return;
            }
            insertAfter(tail, node);
        }

        public void insertBefore(DoublyLinkedListNode node, DoublyLinkedListNode nodeToInsert) {
            if (nodeToInsert == head && nodeToInsert == tail) {
                return;
            }
            remove(nodeToInsert);
            nodeToInsert.prev = node.prev;
            nodeToInsert.next = node;
            if (node.prev == null) {
                head = nodeToInsert;
            } else {
                node.prev.next = nodeToInsert;
            }
            node.prev = nodeToInsert;
        }

        public void insertAfter(DoublyLinkedListNode node, DoublyLinkedListNode nodeToInsert) {
            if (nodeToInsert == head && nodeToInsert == tail) {
                return;
            }
            remove(nodeToInsert);
            nodeToInsert.prev = node;
            nodeToInsert.next = node.next;
            if (node.next == null) {
                tail = nodeToInsert;
            } else {
                node.next.prev = nodeToInsert;
            }
            node.next = nodeToInsert;
        }

        public void insertAtPosition(int position, DoublyLinkedListNode nodeToInsert) {
            if (position == 1) {
                setHead(nodeToInsert);
                return;
            }

            DoublyLinkedListNode current = head;
            while (current != null && position > 1) {
                current = current.next;
                position--;
            }
            if (current != null) {
                insertBefore(current, nodeToInsert);
            } else {
                setTail(nodeToInsert);
            }
        }

        public void removeNodesWithValue(int value) {
            DoublyLinkedListNode current = head;
            while (current != null) {
                DoublyLinkedListNode nodeToRemove = current;
                if (nodeToRemove.value == value) {
                    remove(nodeToRemove);
                }
                current = current.next;
            }
        }

        public void remove(DoublyLinkedListNode node) {
            if (node == head) {
                head = head.next;
            }

            if (node == tail) {
                tail = tail.prev;
            }

            removeNodeBindings(node);
        }

        public void removeNodeBindings(DoublyLinkedListNode node) {
            if (node.prev != null) {
                node.prev.next = node.next;
            }

            if (node.next != null) {
                node.next.prev = node.prev;
            }

            node.prev = null;
            node.next = null;
        }

        public boolean containsNodeWithValue(int value) {
            DoublyLinkedListNode current = head;
            while (current != null) {
                if (current.value == value)
                    return true;
                current = current.next;
            }
            return false;
        }
    }
}
