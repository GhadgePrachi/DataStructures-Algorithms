package recursion.easy;

public class NthFibonacci {
    public static int getNthFib(int n) {
        if (n == 1) {
            return 0;
        }

        if (n == 2) {
            return 1;
        }

        return getNthFib(n - 1) + getNthFib(n - 2);
    }

    public static int getNthFibIterative(int n) {
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
