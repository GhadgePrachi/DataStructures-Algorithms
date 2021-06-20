package algorithms.dynamicprogramming.medium;

import org.junit.Assert;
import org.junit.Test;

public class MinJumpsTest {
    @Test
    public void testMinJumpsSuccess() {
        int[] input = {3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3};
        Assert.assertTrue(MinJumps.minNumberOfJumps(input) == 4);
    }
}
