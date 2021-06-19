package algorithms.recursion.medium;

import org.junit.Assert;
import org.junit.Test;

public class ValidStartingCityTest {
    @Test
    public void testValidStartingCitySuccess() {
        int[] distances = new int[] {5, 25, 15, 10, 15};
        int[] fuel = new int[] {1, 2, 1, 0, 3};
        int mpg = 10;
        int expected = 4;
        Assert.assertEquals(expected, new ValidStartingCity().validStartingCity(distances, fuel, mpg));
    }

    @Test
    public void testValidStartingCityFailure() {
        int[] distances = new int[] {5, 25, 35, 10, 15};
        int[] fuel = new int[] {1, 2, 1, 0, 3};
        int mpg = 10;
        int expected = -1;
        Assert.assertEquals(expected, new ValidStartingCity().validStartingCity(distances, fuel, mpg));
    }
}
