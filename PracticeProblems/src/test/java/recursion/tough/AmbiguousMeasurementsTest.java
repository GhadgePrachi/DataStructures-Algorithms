package recursion.tough;

import org.junit.Assert;
import org.junit.Test;

public class AmbiguousMeasurementsTest {
    @Test
    public void testAmbiguousMeasurementsSuccess() {
        int[][] cups = new int[][] {{200, 210}, {450, 465}, {800, 850}};
        int low = 2100;
        int high = 2300;
        Assert.assertTrue(new AmbiguousMeasurements().ambiguousMeasurements(cups, low, high));
    }
}
