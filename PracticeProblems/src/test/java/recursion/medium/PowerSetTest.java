package recursion.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSetTest {
    @Test
    public void testPowerSetSuccess() {
        List<List<Integer>> output = PowerSet.powerSet(new ArrayList<>(Arrays.asList(1, 2, 3)));
        Assert.assertEquals(8, output.size());
        Assert.assertTrue(contains(output, new ArrayList<>()));
        Assert.assertTrue(contains(output, new ArrayList<>(Arrays.asList(1))));
        Assert.assertTrue(contains(output, new ArrayList<>(Arrays.asList(2))));
        Assert.assertTrue(contains(output, new ArrayList<>(Arrays.asList(1, 2))));
        Assert.assertTrue(contains(output, new ArrayList<>(Arrays.asList(3))));
        Assert.assertTrue(contains(output, new ArrayList<>(Arrays.asList(1, 3))));
        Assert.assertTrue(contains(output, new ArrayList<>(Arrays.asList(2, 3))));
        Assert.assertTrue(contains(output, new ArrayList<>(Arrays.asList(1, 2, 3))));
    }

    public boolean contains(List<List<Integer>> arrayOne, List<Integer> arrayTwo) {
        for (List<Integer> subArray : arrayOne) {
            if (arrayTwo.equals(subArray)) {
                return true;
            }
        }
        return false;
    }
}
