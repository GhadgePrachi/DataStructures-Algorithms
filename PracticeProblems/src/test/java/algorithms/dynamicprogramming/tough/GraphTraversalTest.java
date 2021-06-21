package algorithms.dynamicprogramming.tough;

import algorithms.dynamicprogramming.tough.GraphTraversal;
import org.junit.Assert;
import org.junit.Test;

public class GraphTraversalTest {
    @Test
    public void testGraphTraversalSuccess() {
        int width = 4;
        int height = 3;
        int expected = 10;
        var actual = new GraphTraversal().numberOfWaysToTraverseGraph(width, height);
        Assert.assertTrue(expected == actual);
    }
}
