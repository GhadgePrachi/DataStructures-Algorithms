package algorithms.sorting.verytough;

import org.junit.Assert;
import org.junit.Test;

public class SortedReversalsTest {
    @Test
    public void testSortedReversalsSuccess() {
        int[] input = new int[] {2, 3, 3, 1, 9, 5, 6};
        int expected = 5;
        Assert.assertTrue(SortedReversals.countInversions(input) == expected);
    }
}
