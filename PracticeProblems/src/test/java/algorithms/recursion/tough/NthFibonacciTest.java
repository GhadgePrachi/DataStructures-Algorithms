package algorithms.recursion.tough;

import org.junit.Assert;
import org.junit.Test;

public class NthFibonacciTest {
    @Test
    public void testNthFibonacciSuccess() {
        Assert.assertTrue(NthFibonacci.getNthFib(6 ) == 5);
        Assert.assertTrue(NthFibonacci.getNthFibIterative(6) == 5);
        Assert.assertTrue(NthFibonacci.getNthFibIterative(1) == 0);
        Assert.assertTrue(NthFibonacci.getNthFibIterative(2) == 1);
        Assert.assertTrue(NthFibonacci.getNthFibIterativeOptimal(6) == 5);
    }
}
