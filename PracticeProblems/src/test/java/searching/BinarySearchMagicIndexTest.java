package searching;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchMagicIndexTest {
    @Test
    public void testBinarySearchMagicIndexSuccess() {
        int[] input = {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
        Assert.assertEquals(2, new BinarySearchMagicIndex().indexEqualsValue(input));

        int[] input2 = {-5, -3, 0, 3, 4, 5, 9};
        Assert.assertEquals(3, new BinarySearchMagicIndex().indexEqualsValue2(input2));
    }
}
