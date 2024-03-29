package algorithms.recursion.tough;

import org.junit.Assert;
import org.junit.Test;

public class StaircaseTraversalTest {
    @Test
    public void testStaicaseTraversalSuccess() {
        int stairs = 4;
        int maxSteps = 2;
        int expected = 5;
        int actual = new StaircaseTraversal().staircaseTraversal(stairs, maxSteps);
        Assert.assertTrue(expected == actual);

        int actual2 = new StaircaseTraversal().staircaseTraversalIterative(stairs, maxSteps);
        Assert.assertTrue(expected == actual2);

        int actual3 = new StaircaseTraversal().staircaseTraversalIterativeOptimal(stairs, maxSteps);
        Assert.assertTrue(expected == actual3);
    }
}
