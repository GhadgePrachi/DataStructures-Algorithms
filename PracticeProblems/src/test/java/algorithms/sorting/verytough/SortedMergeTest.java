package algorithms.sorting.verytough;

import org.junit.Assert;
import org.junit.Test;

public class SortedMergeTest {
    @Test
    public void testSortedMergeSuccess() {
        int[] arrayOne = {2, 5, 8, 0, 0, 0, 0};
        int[] arrayTwo = {3, 5, 6, 9};
        int[] expected = {2, 3, 5, 5, 6, 8, 9};
        Assert.assertTrue(compare(SortedMerge.sortedMerge(arrayOne, arrayTwo, 3, 4), expected));
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
