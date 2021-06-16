package searching;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchRangeTest {
    @Test
    public void testBinarySearchRangeSuccess() {
        int[] input = {0, 1, 21, 33, 45, 45, 45, 45, 45, 45, 61, 71, 73};
        int target = 45;
        int[] expected = {4, 9};
        Assert.assertTrue(compare(BinarySearchRange.searchForRange(input, target), expected));
    }

    public boolean compare(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
