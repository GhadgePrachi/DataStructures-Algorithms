package sorting.tough;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class RadixSortTest {
    @Test
    public void testRadixSortSuccess() {
        ArrayList<Integer> input =
                new ArrayList(Arrays.asList(8762, 654, 3008, 345, 87, 65, 234, 12, 2));
        ArrayList<Integer> expected =
                new ArrayList(Arrays.asList(2, 12, 65, 87, 234, 345, 654, 3008, 8762));
        Assert.assertTrue(compare(RadixSort.radixSort(input), expected));
    }

    @Test
    public void testRadixSortEmptyInput() {
        Assert.assertEquals(RadixSort.radixSort(new ArrayList<Integer>()), new ArrayList<Integer>());
    }
    public boolean compare(ArrayList<Integer> arrayOne, ArrayList<Integer> arrayTwo) {
        if (arrayOne.size() != arrayTwo.size()) {
            return false;
        }
        for (int i = 0; i < arrayOne.size(); i++) {
            if (!arrayOne.get(i).equals(arrayTwo.get(i))) {
                return false;
            }
        }
        return true;
    }
}
