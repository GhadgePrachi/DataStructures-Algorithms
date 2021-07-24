package datastructures.linkedlist.tough;

import java.util.HashMap;

public class Clone {
    class  RandomList{
        int value;
        RandomList next;
        RandomList random;

        public RandomList(int value){
            this.value = value;
        }
    }

    public RandomList copy(RandomList list) {
        HashMap<RandomList, RandomList> map = new HashMap<>();

        RandomList X = list;
        while (X != null) {
            RandomList Y = new RandomList(X.value);
            Y.next = null;
            Y.random = null;
            map.put(X, Y);
            X = X.next;
        }

        X = list;
        while (X != null) {
            RandomList Y = map.get(X);
            Y.next = map.get(X.next);
            Y.random = map.get(X.random);
            X = X.next;
        }

        return map.get(list);
    }
}