package algorithms.dynamicprogramming.tough;

import org.junit.Assert;
import org.junit.Test;

public class MaxSumSubMatrixTest {
    @Test
    public void testMaxSumSubMatrixSuccess() {
        int[][] matrix = new int[][] {{5, 3, -1, 5}, {-7, 3, 7, 4}, {12, 8, 0, 0}, {1, -8, -8, 2}};
        int size = 2;
        int expected = 18;
        var actual = new MaxSumSubMatrix().maximumSumSubMatrix(matrix, size);
        Assert.assertTrue(expected == actual);
    }
}
