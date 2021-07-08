package datastructures.arrays.medium;

import java.util.Arrays;

public class SubsequenceMaxProduct {
    static int subsequenceMaxProduct(int[] nums, int n, int k) {
        Arrays.sort(nums);
        int product = 1;

        // CASE I
        // If max element is 0 and k is odd then max product will be 0
        if (nums[n - 1] == 0 && k % 2 != 0)
            return 0;

        // CASE II
        // If all elements are negative and k is odd then max product will be product of rightmost-subarray of size k
        if (nums[n - 1] <= 0 && k % 2 != 0) {
            for (int i = n - 1; i >= n - k; i--)
                product *= nums[i];
            return product;
        }

        int i = 0;
        int j = n - 1;

        // CASE III
        // if k is odd and rightmost element in sorted array is positive then it must come in subsequence
        // Multiplying A[j] with product and correspondingly changing j
        if (k % 2 != 0) {
            product *= nums[j];
            j--;
            k--;
        }

        // CASE IV
        // Now k is even. Now we deal with pairs. Each time a pair is multiplied to product ie.. two elements are added to subsequence each time. Effectively k becomes half. Hence, k >>= 1 means k /= 2
        k >>= 1;
        for (int itr = 0; itr < k; itr++) {
            // product from left pointers
            int left_product = nums[i] * nums[i + 1];

            // product from right pointers
            int right_product = nums[j] * nums[j - 1];

            // Taking the max product from two choices
            // Correspondingly changing the pointer's position
            if (left_product > right_product) {
                product *= left_product;
                i += 2;
            }
            else {
                product *= right_product;
                j -= 2;
            }
        }

        // Finally return product
        return product;
    }

}
