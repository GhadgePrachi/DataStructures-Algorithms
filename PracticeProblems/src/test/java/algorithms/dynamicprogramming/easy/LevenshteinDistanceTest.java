package algorithms.dynamicprogramming.easy;

import org.junit.Assert;
import org.junit.Test;

public class LevenshteinDistanceTest {
    @Test
    public void testLevenshteinDistanceSuccess() {
        Assert.assertTrue(LevenshteinDistance.levenshteinDistance("abc", "yabd") == 2);
    }
}
