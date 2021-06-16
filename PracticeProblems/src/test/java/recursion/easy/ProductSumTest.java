package recursion.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductSumTest {
    @Test
    public void testProductSumSuccess() {
        List<Object> test = new ArrayList<Object>( Arrays.asList(5, 2, new ArrayList<Object>(Arrays.asList(7, -1)), 3, new ArrayList<Object> (Arrays.asList(6, new ArrayList<Object>(Arrays.asList(-13, 8)), 4))));
        Assert.assertEquals(12, ProductSum.productSum(test));
    }

    @Test
    public void testProductSumEmptyInput() {
        Assert.assertEquals(-1, ProductSum.productSum(new ArrayList<>()));
    }
}
