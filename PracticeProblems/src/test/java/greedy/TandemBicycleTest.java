package greedy;

import org.junit.Assert;
import org.junit.Test;

public class TandemBicycleTest {
    @Test
    public void testTandemBicycleSuccess() {
        int[] redShirtSpeeds = new int[] {5, 5, 3, 9, 2};
        int[] blueShirtSpeeds = new int[] {3, 6, 7, 2, 1};
        boolean fastest = true;
        int expected = 32;
        Assert.assertEquals(expected, new TandemBicycle().tandemBicycle(redShirtSpeeds, blueShirtSpeeds, fastest));
    }
}
