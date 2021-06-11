package sorting.verytough;

import org.junit.Assert;
import org.junit.Test;
import sorting.verytough.MergeSort;

public class MergeSortTest {
    @Test
    public void testMergeSortSuccess() {
        int[] input = {8, 5, 2, 9, 5, 6, 3};
        int[] expected = {2, 3, 5, 5, 6, 8, 9};
        Assert.assertTrue(compare(MergeSort.mergeSort(input), expected));
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
