package algorithms.dynamicprogramming.easy;

import org.junit.Assert;
import org.junit.Test;

public class TotalWaysToMakeChangeTest {
    @Test
    public void testNumberOfWaysToMakeCoinsSuccess() {
        int[] input = {1, 5};
        Assert.assertTrue(TotalWaysToMakeChange.numberOfWaysToMakeChange(6, input) == 2);
    }
}
