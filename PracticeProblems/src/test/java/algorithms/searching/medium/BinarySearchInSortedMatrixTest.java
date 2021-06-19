package algorithms.searching.medium;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchInSortedMatrixTest {
    @Test
    public void testBinarySearchInSortedMatrixSuccess() {
        int[][] matrix = {
                {1, 4, 7, 12, 15, 1000},
                {2, 5, 19, 31, 32, 1001},
                {3, 8, 24, 33, 35, 1002},
                {40, 41, 42, 44, 45, 1003},
                {99, 100, 103, 106, 128, 1004},
        };
        int target = 44;
        int[] expected = {3, 3};
        Assert.assertTrue(compare(expected, BinarySearchInSortedMatrix.searchInSortedMatrix(matrix, target)));
    }

    @Test
    public void testBinarySearchInSortedMatrixFailure() {
        int[][] matrix = {
                {1, 4, 7, 12, 15, 1000},
                {2, 5, 19, 31, 32, 1001},
                {3, 8, 24, 33, 35, 1002},
                {40, 41, 42, 44, 45, 1003},
                {99, 100, 103, 106, 128, 1004},
        };
        int target = 111;
        int[] expected = {-1, -1};
        Assert.assertTrue(compare(expected, BinarySearchInSortedMatrix.searchInSortedMatrix(matrix, target)));
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
