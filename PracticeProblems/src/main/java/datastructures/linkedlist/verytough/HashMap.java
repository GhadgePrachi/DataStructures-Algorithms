package datastructures.linkedlist.verytough;

import java.util.ArrayList;

public class HashMap<K,V> {
    private ArrayList<LinkedHashNode> elements;
    int capacity = 0, size = 0;

    public HashMap() {
        elements = new ArrayList<LinkedHashNode>();
    }

    public HashMap(int capacity) {
        this.capacity = capacity;
        elements = new ArrayList<LinkedHashNode>(this.capacity);
    }

    public boolean isEmpty() {
        return elements == null;
    }

    public int getIndexForKey(K key) {
        return Math.abs(key.hashCode() % this.elements.size());
    }

    public LinkedHashNode getNodeForKey(K key) {
        int index = getIndexForKey(key);
        LinkedHashNode current = this.elements.get(index);

        while (current != null) {
            if (current.key == key) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public V put(K key, V value) {
        LinkedHashNode node = getNodeForKey(key);

        if (node != null) {
            V oldValue = (V) node.value;
            node.value = value;
            return oldValue;
        }

        int index = getIndexForKey(key);
        node = new LinkedHashNode(key, value);
        if (this.elements.get(index) != null) {
            node.next = elements.get(index);
            node.next.prev = node;
        }
        this.elements.set(index, node);
        return null;
    }


    public V get(K key) {
        if (key == null) {
            return null;
        }
        LinkedHashNode node = getNodeForKey(key);
        return node == null ? null : (V) node.value;
    }

    public V remove(K key) {
        if (key == null) {
            return null;
        }

        LinkedHashNode node = getNodeForKey(key);
        if (node == null) {
            return null;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            int index = getIndexForKey(key);
            this.elements.set(index, node.next);
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }
        return (V) node.value;
    }

    private static class LinkedHashNode<K, V> {
        final K key;
        V value;
        LinkedHashNode<K, V> next;
        LinkedHashNode<K, V> prev;

        public LinkedHashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;

            if ((obj instanceof LinkedHashNode)) {

                if (this.key.equals(((LinkedHashNode) obj).getKey()) && this.value.equals(((LinkedHashNode) obj).getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public int hashCode() {
            int h;
            return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        }

        public String toString() {
            String data = "(" + key + "," + value + ")";

            if (next != null) {
                data = data + "->" + next.toString();
            }

            return data;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

    }
}