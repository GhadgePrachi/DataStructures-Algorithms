package searching;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchSpacesTest {
    @Test
    public void testBinarySearchSpacesSuccess() {
        String[] input = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        String target = "ball";
        int expected = 4;
        Assert.assertEquals(expected, new BinarySearchSpaces().sparseSearch(input, target));
    }
}
