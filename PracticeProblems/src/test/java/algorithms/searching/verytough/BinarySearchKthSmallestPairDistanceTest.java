package algorithms.searching.verytough;

import algorithms.searching.tough.BinarySearchMinInShifted;
import org.junit.Assert;
import org.junit.Test;

public class BinarySearchKthSmallestPairDistanceTest {
    @Test
    public void testBinarySearchKthSmallestPairDistanceSuccess() {
        int[] input = {1,3,1};
        int k = 1;
        int expected = 0;
        Assert.assertEquals(expected, new BinarySearchKthSmallestPairDistance().kthSmallestPairDistance(input, k));

        int[] input2 = {1,1,1};
        int k2 = 2;
        int expected2 = 0;
        Assert.assertEquals(expected2, new BinarySearchKthSmallestPairDistance().kthSmallestPairDistance(input2, k2));

        int[] input3 = {1,6,1};
        int k3 = 3;
        int expected3 = 5;
        Assert.assertEquals(expected3, new BinarySearchKthSmallestPairDistance().kthSmallestPairDistance(input3, k3));
    }
}
