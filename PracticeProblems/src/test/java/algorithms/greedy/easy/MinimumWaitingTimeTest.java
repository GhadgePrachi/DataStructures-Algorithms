package algorithms.greedy.easy;

import org.junit.Assert;
import org.junit.Test;

public class MinimumWaitingTimeTest {
    @Test
    public void testMinimumWaitingTimeSuccess() {
        int[] queries = new int[]{3, 2, 1, 2, 6};
        int expected = 17;
        Assert.assertEquals(expected, new MinimumWaitingTime().minimumWaitingTime(queries));
    }
}
