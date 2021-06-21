package algorithms.dynamicprogramming.medium;

import algorithms.dynamicprogramming.medium.Transactions;
import org.junit.Assert;
import org.junit.Test;

public class TransactionsTest {
    @Test
    public void testTransactionsSuccess() {
        int[] input1 = {7, 1, 5, 3, 6, 4};
        int expected1 = 5;
        Assert.assertTrue(Transactions.maxProfitWithOneTransaction(input1) == expected1);

        int[] input2 = {3,3,5,0,0,3,1,4};
        int expected2 = 6;
        Assert.assertTrue(Transactions.maxProfitWithTwoTransactions(input2) == expected2);

        int[] input3 = {1, 2, 3, 4, 5};
        int expected3 = 4;
        Assert.assertTrue(Transactions.maxProfitWithAnyTransactions(input3) == expected3);

        int[] input = {5, 11, 3, 50, 60, 90};
        Assert.assertTrue(Transactions.maxProfitWithKTransactions(input, 2) == 93);
        Assert.assertTrue(Transactions.maxProfitWithKTransactionsOptimal(input, 2) == 93);
    }
}
