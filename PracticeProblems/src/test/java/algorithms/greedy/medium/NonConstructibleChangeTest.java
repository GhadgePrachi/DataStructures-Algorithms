package algorithms.greedy.medium;

import org.junit.Assert;
import org.junit.Test;

public class NonConstructibleChangeTest {
    @Test
    public void testNonConstructibleChangeSuccess() {
        int[] input = new int[] {5, 7, 1, 1, 2, 3, 22};
        int expected = 20;
        Assert.assertTrue(expected == new NonConstructibleChange().nonConstructibleChange(input));
    }
}
