package algorithms.dynamicprogramming.tough;

import algorithms.dynamicprogramming.tough.LongestCommonSubsequence;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class LongestCommonSubsequenceTest {
    @Test
    public void testLongestCommonSubsequenceSuccess() {
        char[] expected = {'X', 'Y', 'Z', 'W'};
        Assert.assertTrue(compare(LongestCommonSubsequence.longestCommonSubsequence("ZXVVYZW", "XKYKZPW"), expected));
    }

    private static boolean compare(List<Character> arr1, char[] arr2) {
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
