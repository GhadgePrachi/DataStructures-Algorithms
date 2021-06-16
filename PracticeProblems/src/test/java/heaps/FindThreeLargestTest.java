package heaps;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindThreeLargestTest {
    @Test
    public void testFindThreeLargestSuccess() {
        int[] input = {141, 1, 17, 2, -7, -17, -27, 18, 541, 8, 7, 7};
        int[] expected = {18, 141, 541};
        Assert.assertTrue(compare(FindThreeLargest.findThreeLargestNumbers(input),expected));

        List<Integer> input2 = new ArrayList<>(Arrays.asList(141, 1, 2, 17, -7, -17, -27, 18, 541, 8, 7, 7));
        List<Integer> expected2 = new ArrayList<>(Arrays.asList(18, 141, 541));
        Assert.assertTrue(compare(FindThreeLargest.findThreeLargestNumbers(input2), expected2));
    }

    public boolean compare(int[] arrayOne, int[] arrayTwo) {
        if (arrayOne.length != arrayTwo.length) {
            return false;
        }
        for (int i = 0; i < arrayOne.length; i++) {
            if (arrayOne[i] != arrayTwo[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean compare(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if (arrayOne.size() != arrayTwo.size()) {
            return false;
        }
        for (int i = 0; i < arrayOne.size(); i++) {
            if (!arrayOne.get(i).equals(arrayTwo.get(i))) {
                return false;
            }
        }
        return true;
    }
}
