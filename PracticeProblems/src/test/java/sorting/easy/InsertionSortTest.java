package sorting.easy;
import org.junit.Test;
import org.junit.Assert;
import sorting.easy.InsertionSort;

public class InsertionSortTest {
    @Test
    public void testInsertionSortSuccess() {
        int[] input = {8, 5, 2, 9, 5, 6, 3};
        int[] expected = {2, 3, 5, 5, 6, 8, 9};
        Assert.assertTrue(compare(InsertionSort.insertionSort(input), expected));
    }

    public boolean compare(int[] arrayOne, int[] arrayTwo) {
        if (arrayOne.length != arrayTwo.length) {
            return false;
        }
        for (int i = 0; i < arrayOne.length; i++) {
            if (arrayOne[i] != arrayTwo[i]) {
                return false;
            }
        }
        return true;
    }
}
