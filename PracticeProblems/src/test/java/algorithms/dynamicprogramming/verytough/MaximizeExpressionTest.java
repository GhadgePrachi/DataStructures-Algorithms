package algorithms.dynamicprogramming.verytough;

import org.junit.Assert;
import org.junit.Test;

public class MaximizeExpressionTest {
    @Test
    public void testMaximizeExpressionSuccess() {
        int[] input = new int[] {3, 6, 1, -3, 2, 7};
        int expected = 4;
        var actual = new MaximizeExpression().maximizeExpression(input);
        Assert.assertTrue(expected == actual);
    }
}
