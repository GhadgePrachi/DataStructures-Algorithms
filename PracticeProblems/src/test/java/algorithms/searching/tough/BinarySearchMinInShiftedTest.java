package algorithms.searching.tough;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchMinInShiftedTest {
    @Test
    public void testBinarySearchMinInShiftedSuccess() {
        int[] input = {3,4,5,1,2};
        int expected = 1;
        Assert.assertEquals(expected, new BinarySearchMinInShifted().findMin(input));
    }
}
