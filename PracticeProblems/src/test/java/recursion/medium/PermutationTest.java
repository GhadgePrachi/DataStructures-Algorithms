package recursion.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationTest {
    @Test
    public void testPermutationSuccess() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<List<Integer>> output = Permutation.getPermutations(input);
        Assert.assertEquals(6, output.size());
        Assert.assertTrue(contains(output, new ArrayList<>(Arrays.asList(1, 2, 3))));
        Assert.assertTrue(contains(output, new ArrayList<>(Arrays.asList(1, 3, 2))));
        Assert.assertTrue(contains(output, new ArrayList<>(Arrays.asList(2, 1, 3))));
        Assert.assertTrue(contains(output, new ArrayList<>(Arrays.asList(2, 3, 1))));
        Assert.assertTrue(contains(output, new ArrayList<>(Arrays.asList(3, 1, 2))));
        Assert.assertTrue(contains(output, new ArrayList<>(Arrays.asList(3, 2, 1))));
    }

    public boolean contains(List<List<Integer>> arrayOne, List<Integer> arrayTwo) {
        for (List<Integer> subArray : arrayOne) {
            if (subArray.equals(arrayTwo)) {
                return true;
            }
        }
        return false;
    }
}
