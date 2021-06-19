package algorithms.searching.easy;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchBoundsTest {
    @Test
    public void testBinarySearchBoundsSuccess() {
        int expected = 4;
        Assert.assertEquals(expected, new BinarySearchBounds(4).firstBadVersion(5));
    }

    @Test
    public void testBinarySearchBoundsFailure() {
        int expected = 1;
        Assert.assertEquals(expected, new BinarySearchBounds(1).firstBadVersion(1));
    }
}
