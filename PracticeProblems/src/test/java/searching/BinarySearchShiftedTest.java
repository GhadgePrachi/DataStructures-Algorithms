package searching;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchShiftedTest {
    @Test
    public void testBinarySearchShiftedSuccess() {
        int[] input = {45, 61, 71, 72, 73, 0, 1, 21, 33, 37};
        int target = 33;
        int expected = 8;
        Assert.assertEquals(expected, BinarySearchShifted.shiftedBinarySearch(input, target));

        int[] input2 = {45, 61, 71, 72, 73, 0, 1, 21, 33, 37};
        int target2 = 71;
        int expected2 = 2;
        Assert.assertEquals(expected2, BinarySearchShifted.shiftedBinarySearch(input2, target2));

        int[] input3 = {45, 61, 0, 1, 2, 7, 21, 27, 33, 37};
        int target3 = 61;
        int expected3 = 1;
        Assert.assertEquals(expected3, BinarySearchShifted.shiftedBinarySearch(input3, target3));

        int[] input4 = {45, 61, 0, 1, 2, 7, 21, 27, 33, 37};
        int target4 = 27;
        int expected4 = 7;
        Assert.assertEquals(expected4, BinarySearchShifted.shiftedBinarySearch(input4, target4));

        int[] input5 = {2,2,2,2,2,4,7};
        int target5 = 4;
        int expected5 = 5;
        Assert.assertEquals(expected5, BinarySearchShifted.shiftedBinarySearch(input5, target5));

        int[] input6 = {2,1,2,2,2,2};
        int target6 = 1;
        int expected6 = 1;
        Assert.assertEquals(expected6, BinarySearchShifted.shiftedBinarySearch(input6, target6));
    }

    @Test
    public void testBinarySearchShiftedFailure() {
        int[] input = {45, 61, 71, 72, 73, 0, 1, 21, 33, 37};
        int target = 11;
        int expected = -1;
        Assert.assertEquals(expected, BinarySearchShifted.shiftedBinarySearch(input, target));

        int target2 = 66;
        int expected2 = -1;
        Assert.assertEquals(expected2, BinarySearchShifted.shiftedBinarySearch(input, target2));
    }
}
