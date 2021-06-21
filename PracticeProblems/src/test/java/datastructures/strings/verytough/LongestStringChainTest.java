package datastructures.strings.verytough;

import datastructures.strings.verytough.LongestStringChain;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestStringChainTest {
    @Test
    public void testLongestStringChainSuccess() {
        List<String> strings =
                new ArrayList<String>(
                        Arrays.asList("abde", "abc", "abd", "abcde", "ade", "ae", "1abde", "abcdef"));
        List<String> expected =
                new ArrayList<String>(Arrays.asList("abcdef", "abcde", "abde", "ade", "ae"));
        Assert.assertTrue(LongestStringChain.longestStringChain(strings).equals(expected));
    }
}
