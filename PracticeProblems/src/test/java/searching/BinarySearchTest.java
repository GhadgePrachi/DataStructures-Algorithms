package searching;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {
    @Test
    public void testBinarySearchSuccess() {
        int[] input = {0, 1, 21, 33, 45, 45, 61, 71, 72, 73};
        int target = 33;
        int expected = 3;
        Assert.assertEquals(expected, BinarySearch.binarySearch(input, target));
    }

    @Test
    public void testBinarySearchFailure() {
        int[] input = {0, 1, 21, 33, 45, 45, 61, 71, 72, 73};
        int target = 11;
        int expected = -1;
        Assert.assertEquals(expected, BinarySearch.binarySearch(input, target));
    }
}
