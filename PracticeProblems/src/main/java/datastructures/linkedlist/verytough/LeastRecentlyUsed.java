package datastructures.linkedlist.verytough;

import java.util.HashMap;

public class LeastRecentlyUsed {
    static class DoublyLinkedList {
        DoublyLinkedListNode head;
        DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }
    }
    static class DoublyLinkedListNode {
        public String key;
        public int value;
        public DoublyLinkedListNode prev;
        public DoublyLinkedListNode next;

        public DoublyLinkedListNode(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static class LRUResult {
        boolean found;
        int value;

        public LRUResult(boolean found, int value) {
            this.found = found;
            this.value = value;
        }
    }

    static class LRUCache {
        int maxSize;
        DoublyLinkedList listOfRecent = new DoublyLinkedList();
        HashMap<String, DoublyLinkedListNode> cache = new HashMap<>();

        public LRUCache(int maxSize) {
            this.maxSize = maxSize;
        }

        public void insertKeyValuePair(String key, int value) {
            if (!cache.containsKey(key)) {
                if (cache.size() == maxSize && listOfRecent.head != null) {
                    removeKey(listOfRecent.tail.key);
                }
            } else {
                removeKey(key);
            }

            DoublyLinkedListNode node = new DoublyLinkedListNode(key, value);
            insertAtFrontOfLinkedList(node);
            cache.put(key, node);
        }

        public LRUResult getValueFromKey(String key) {
            if (!cache.containsKey(key)) {
                return new LRUResult(false, -1);
            }

            DoublyLinkedListNode node = cache.get(key);
            removeFromLinkedList(node);
            insertAtFrontOfLinkedList(node);
            return new LRUResult(true, node.value);
        }

        public String getMostRecentKey() {
            if (listOfRecent.head == null) {
                return "";
            }

            String keyToBeRemoved = listOfRecent.head.key;
            return keyToBeRemoved;
        }

        public void removeKey(String key) {
            removeFromLinkedList(cache.get(key));
            cache.remove(key);
        }

        public void removeFromLinkedList(DoublyLinkedListNode node) {
            if (node == null) {
                return;
            }

            if (node == listOfRecent.head) {
                listOfRecent.head = listOfRecent.head.next;
            }

            if (node == listOfRecent.tail) {
                listOfRecent.tail = listOfRecent.tail.prev;
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

        public void insertAtFrontOfLinkedList(DoublyLinkedListNode node) {
            if (listOfRecent.head == null) {
                listOfRecent.head = node;
                listOfRecent.tail = node;
            } else {
                listOfRecent.head.prev = node;
                node.next = listOfRecent.head;
                listOfRecent.head = node;
            }
        }
    }
}
