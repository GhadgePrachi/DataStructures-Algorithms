package algorithms.dynamicprogramming.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class LongestIncreasingSubsequenceTest {
    @Test
    public void testLongestIncreasingSubsequenceSuccess() {
        int[] expected = {-24, 2, 3, 5, 6, 35};
        Assert.assertTrue(compare(LongestIncreasingSubsequence.longestIncreasingSubsequence(new int[] {5, 7, -24, 12, 10, 2, 3, 12, 5, 6, 35}), expected));
    }

    public static boolean compare(List<Integer> arr1, int[] arr2) {
        if (arr1.size() != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.size(); i++) {
            if (arr1.get(i) != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
