package algorithms.dynamicprogramming.tough;

import org.junit.Assert;
import org.junit.Test;

public class WaterAreaTest {
    @Test
    public void testWaterAreaSuccess() {
        int[] input = {0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3};
        Assert.assertTrue(WaterArea.waterArea(input) == 48);
    }
}
