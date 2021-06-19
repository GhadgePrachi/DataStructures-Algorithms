package algorithms.searching.medium;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchUnboundedTest {
    @Test
    public void testBinarySearchUnboundedSuccess() {
        int[] input = {0, 1, 21, 33, 45, 45, 61, 71, 72, 73, -1, -1, -1, -1, -1, -1, -1};
        BinarySearchUnbounded.Listy list = new BinarySearchUnbounded.Listy(input);
        int target = 33;
        int expected = 3;
        Assert.assertEquals(expected, BinarySearchUnbounded.unboundedSearch(list, target));
    }

    @Test
    public void testBinarySearchUnboundedFailure() {
        int[] input = {0, 1, 21, 33, 45, 45, 61, 71, 72, 73,  -1, -1, -1, -1, -1, -1, -1};
        BinarySearchUnbounded.Listy list = new BinarySearchUnbounded.Listy(input);
        int target = 11;
        int expected = -1;
        Assert.assertEquals(expected, BinarySearchUnbounded.unboundedSearch(list, target));
    }
}
