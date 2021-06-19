package algorithms.searching.tough;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchSquaresTest {
    @Test
    public void testBinarySearchSquaresSuccess() {
        int num = 16;
        Assert.assertTrue(new BinarySearchSquares().isSquare(num));

        int expected = 2;
        Assert.assertEquals(expected, new BinarySearchSquares().getSquareRoot(5));
    }

    @Test
    public void testBinarySearchSquaresFailure() {
        int num = 15;
        Assert.assertFalse(new BinarySearchSquares().isSquare(num));
    }
}
