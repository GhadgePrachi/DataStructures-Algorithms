package algorithms.dynamicprogramming.easy;

import org.junit.Assert;
import org.junit.Test;

public class NumberOfWaysToMakeCoinsTest {
    @Test
    public void testNumberOfWaysToMakeCoinsSuccess() {
        int[] input = {1, 5};
        Assert.assertTrue(NumberOfWaysToMakeCoins.numberOfWaysToMakeChange(6, input) == 2);
    }
}
