package sorting.medium;

import org.junit.Assert;
import org.junit.Test;

public class SortThreeTest {
    @Test
    public void testSortThreeSuccess() {
        int[] input = {0, 1, 2, 2, 0, 1, 1};
        int[] order = {0, 1, 2};
        int[] expected = {0, 0, 1, 1, 1, 2, 2};
        Assert.assertTrue(compare(SortThree.sortThree(input, order), expected));
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
}
