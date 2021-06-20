package algorithms.dynamicprogramming.verytough;

import org.junit.Assert;
import org.junit.Test;

public class TransactionsTest {
    @Test
    public void testTransactionsSuccess() {
        int[] input = {5, 11, 3, 50, 60, 90};
        Assert.assertTrue(Transactions.maxProfitWithKTransactions(input, 2) == 93);
    }
}
