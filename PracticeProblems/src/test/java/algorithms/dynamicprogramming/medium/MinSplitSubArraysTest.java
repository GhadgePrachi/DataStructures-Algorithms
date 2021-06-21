package algorithms.dynamicprogramming.medium;

import org.junit.Assert;
import org.junit.Test;

public class MinSplitSubArraysTest {
    @Test
    public void testMinSplitSubArraysSuccess() {
        int[] nums = {7,2,5,10,8};
        int k = 2;
        int expected = 18;
        Assert.assertEquals(expected, new MinSplitSubArrays().splitArray(nums, k));
    }
}
