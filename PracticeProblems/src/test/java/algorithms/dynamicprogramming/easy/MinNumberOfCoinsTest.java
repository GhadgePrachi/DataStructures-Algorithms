package algorithms.dynamicprogramming.easy;

import org.junit.Assert;
import org.junit.Test;

public class MinNumberOfCoinsTest {
    @Test
    public void testMinNumberOfCoinsSuccess() {
        int[] input = {1, 5, 10};
        Assert.assertTrue(MinNumberOfCoins.minNumberOfCoinsForChange(7, input) == 3);
    }
}
