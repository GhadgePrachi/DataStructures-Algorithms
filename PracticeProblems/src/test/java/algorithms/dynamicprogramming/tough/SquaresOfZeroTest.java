package algorithms.dynamicprogramming.tough;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SquaresOfZeroTest {
    @Test
    public void testSquaresOfZeroSuccess() {
        List<List<Integer>> test = new ArrayList<List<Integer>>();
        test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {1, 1, 1, 0, 1, 0})));
        test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {0, 0, 0, 0, 0, 1})));
        test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {0, 1, 1, 1, 0, 1})));
        test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {0, 0, 0, 1, 0, 1})));
        test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {0, 1, 1, 1, 0, 1})));
        test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {0, 0, 0, 0, 0, 1})));
        Assert.assertTrue(SquaresOfZero.squareOfZeroes(test));
    }
}
