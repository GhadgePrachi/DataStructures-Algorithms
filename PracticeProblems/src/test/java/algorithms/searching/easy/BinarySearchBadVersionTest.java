package algorithms.searching.easy;

import algorithms.searching.tough.BinarySearchBadVersion;
import org.junit.Assert;
import org.junit.Test;

public class BinarySearchBadVersionTest {
    @Test
    public void testBinarySearchBoundsSuccess() {
        int expected = 4;
        Assert.assertEquals(expected, new BinarySearchBadVersion(4).firstBadVersion(5));
    }

    @Test
    public void testBinarySearchBoundsFailure() {
        int expected = 1;
        Assert.assertEquals(expected, new BinarySearchBadVersion(1).firstBadVersion(1));
    }
}
