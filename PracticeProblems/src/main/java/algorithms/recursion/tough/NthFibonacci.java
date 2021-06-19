package algorithms.recursion.tough;

import java.util.HashMap;

public class NthFibonacci {
    public static int getNthFib(int n) {
        HashMap<Integer, Integer> fibonaccis = new HashMap<>();
        fibonaccis.put(1,0);
        fibonaccis.put(2,1);
        return getNthFib(n, fibonaccis);
    }

    public static int getNthFib(int n, HashMap<Integer, Integer> fibonaccis) {
        if (fibonaccis.containsKey(n)) {
            return fibonaccis.get(n);
        }

        int val =  getNthFib(n - 1, fibonaccis) + getNthFib(n - 2, fibonaccis);
        fibonaccis.put(n, val);
        return val;
    }

    public static int getNthFibIterative(int n) {
        int[] lastTwo = new int[] {0, 1};
        for (int i = 3; i <= n ; i++) {
            int current = lastTwo[0] + lastTwo[1];
            lastTwo[0] = lastTwo[1];
            lastTwo[1] = current;
        }
        return n > 1 ? lastTwo[1] : lastTwo[0];
    }

    public static int getNthFibIterativeOptimal(int n) {
        if (n == 1) {
            return 0;
        }

        if (n == 2) {
            return 1;
        }

        int lastTwo = 0, lastOne = 1, current = 1;
        for (int i = 3; i <= n ; i++) {
            current = lastOne + lastTwo;
            lastTwo = lastOne;
            lastOne = current;
        }
        return current;
    }
}
