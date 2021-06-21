package algorithms.dynamicprogramming.tough;

import algorithms.dynamicprogramming.tough.LevenshteinDistance;
import org.junit.Assert;
import org.junit.Test;

public class LevenshteinDistanceTest {
    @Test
    public void testLevenshteinDistanceSuccess() {
        Assert.assertTrue(LevenshteinDistance.levenshteinDistance("abc", "yabd") == 2);
    }
}
