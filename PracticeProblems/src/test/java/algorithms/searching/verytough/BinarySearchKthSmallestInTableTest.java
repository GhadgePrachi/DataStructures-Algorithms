package algorithms.searching.verytough;

import algorithms.searching.tough.BinarySearchMinInShifted;
import org.junit.Assert;
import org.junit.Test;

public class BinarySearchKthSmallestInTableTest {
    @Test
    public void testBinarySearchKthSmallestInTableSuccess() {
        int m = 3, n = 3, k = 5;
        int expected = 3;
        Assert.assertEquals(expected, new BinarySearchKthSmallestInTable().findKthNumber(m, n, k));

        int m2 = 2, n2 = 3, k2 = 6;
        int expected2 = 6;
        Assert.assertEquals(expected2, new BinarySearchKthSmallestInTable().findKthNumber(m2, n2, k2));
    }
}
