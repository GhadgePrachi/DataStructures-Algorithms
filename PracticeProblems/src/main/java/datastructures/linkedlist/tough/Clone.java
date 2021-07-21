package datastructures.linkedlist.tough;

import java.util.HashMap;

public class Clone {
    class  RandomListNode{
        int label;
        RandomListNode next;
        RandomListNode random;

        RandomListNode(int l){
            this.label = l;
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

        RandomListNode X = head;
        while (X != null) {
            RandomListNode Y = new RandomListNode(X.label);
            Y.next = null;
            Y.random = null;
            map.put(X, Y);

            X = X.next;
        }

        X = head;
        while (X != null) {
            RandomListNode current = map.get(X);
            current.next = map.get(X.next);
            current.random = map.get(X.random);

            X = X.next;
        }

        return map.get(head);
    }
}
