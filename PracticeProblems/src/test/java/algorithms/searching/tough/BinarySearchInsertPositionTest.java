package algorithms.searching.tough;

import algorithms.searching.easy.BinarySearch;
import org.junit.Assert;
import org.junit.Test;

public class BinarySearchInsertPositionTest {
    @Test
    public void testBinarySearchInsertPositionSuccess() {
        int[] input = {1,3,5,6};
        int target = 5;
        int expected = 2;
        Assert.assertEquals(expected, new BinarySearchInsertPosition().searchInsert(input, target));

        int target2 = 3;
        int expected2 = 1;
        Assert.assertEquals(expected2, new BinarySearchInsertPosition().searchInsert(input, target2));

        int[] houses = {1,2,3,4};
        int[] heaters = {1,4};
        int expected3 = 1;
        Assert.assertEquals(expected3, new BinarySearchInsertPosition().findRadius(houses, heaters));
    }
}
