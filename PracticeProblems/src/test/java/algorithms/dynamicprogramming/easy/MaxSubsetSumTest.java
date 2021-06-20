package algorithms.dynamicprogramming.easy;

import org.junit.Assert;
import org.junit.Test;

public class MaxSubsetSumTest {
    @Test
    public void testMaxSubsetSumSuccess() {
        int[] input = {75, 105, 120, 75, 90, 135};
        Assert.assertTrue(MaxSubsetSum.maxSubsetSumNoAdjacent(input) == 330);
    }
}
