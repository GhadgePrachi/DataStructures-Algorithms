package algorithms.dynamicprogramming.medium;

import org.junit.Assert;
import org.junit.Test;

public class PalindromePartitionTest {
    @Test
    public void testPalindromePartitionSuccess() {
        Assert.assertTrue(PalindromePartition.palindromePartitioningMinCuts("noonabbad") == 2);
    }
}
