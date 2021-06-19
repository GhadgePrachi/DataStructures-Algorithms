package algorithms.searching.tough;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchNextGreatestTest {
    @Test
    public void testBinarySearchNextGreatestSuccess() {
        char[] input = {'c','f', 'j'};
        char target = 'a';
        char expected = 'c';
        Assert.assertEquals(expected, new BinarySearchNextGreatest().nextGreatestLetter(input, target));

        char target2 = 'c';
        char expected2 = 'f';
        Assert.assertEquals(expected2, new BinarySearchNextGreatest().nextGreatestLetter(input, target2));

        char target3 = 'd';
        char expected3 = 'f';
        Assert.assertEquals(expected3, new BinarySearchNextGreatest().nextGreatestLetter(input, target3));

        char target4 = 'j';
        char expected4 = 'c';
        Assert.assertEquals(expected4, new BinarySearchNextGreatest().nextGreatestLetter(input, target4));
    }
}
