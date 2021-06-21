package algorithms.dynamicprogramming.easy;

import org.junit.Assert;
import org.junit.Test;

public class MinCoinsToMakeChangeTest {
    @Test
    public void testMinNumberOfCoinsSuccess() {
        int[] input = {1, 5, 10};
        Assert.assertTrue(MinCoinsToMakeChange.minNumberOfCoinsForChange(7, input) == 3);
    }
}
