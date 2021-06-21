package algorithms.dynamicprogramming.medium;

import org.junit.Assert;
import org.junit.Test;

public class WordPartitionTest {
    @Test
    public void testWordPartitionSuccess() {
        String[] words = {"This","is", "example", "an", "anexample", "Thisisanexample", "Thisistheexample"};
        String expected = "Thisisanexample";
        Assert.assertTrue(new WordPartition().longestWord(words).equals(expected));
    }
}
