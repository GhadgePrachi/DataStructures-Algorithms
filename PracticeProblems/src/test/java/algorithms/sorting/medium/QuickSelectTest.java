package algorithms.sorting.medium;

import org.junit.Assert;
import org.junit.Test;

public class QuickSelectTest {
    @Test
    public void testQuickSelectSuccess() {
        int[] input = {8, 5, 2, 9, 5, 6, 3};
        int k = 6;
        int expected = 8;
        Assert.assertEquals(expected, QuickSelect.quickselect(input, k));
    }

    @Test
    public void testQuickSelectFailure() {
        int[] input = {8, 5, 2, 9, 5, 6, 3};
        int k = 8;
        int expected = -1;
        Assert.assertEquals(expected, QuickSelect.quickselect(input, k));
    }
}
