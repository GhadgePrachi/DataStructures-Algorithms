package algorithms.dynamicprogramming.medium;

import org.junit.Assert;
import org.junit.Test;

public class PiePartitionTest {
    String PI = "3141592653589793238462643383279";
    @Test
    public void testNumberOfPieSuccess() {
        String[] numbers = new String[] {"314159265358979323846", "26433", "8", "3279", "314159265", "35897932384626433832", "79"};
        Assert.assertTrue(PiePartition.numbersInPi(PI, numbers) == 2);
    }
}
