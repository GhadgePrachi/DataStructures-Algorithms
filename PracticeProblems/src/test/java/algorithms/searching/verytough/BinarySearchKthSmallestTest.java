package algorithms.searching.verytough;

import algorithms.searching.tough.BinarySearchMinInShifted;
import org.junit.Assert;
import org.junit.Test;

public class BinarySearchKthSmallestTest {
    @Test
    public void testBinarySearchKthSmallestSuccess() {
        int[][] input = {{1,5,9},{10,11,13},{12,13,15}};
        int k = 8;
        int expected = 13;
        Assert.assertEquals(expected, new BinarySearchKthSmallest().kthSmallest(input, k));
    }
}
