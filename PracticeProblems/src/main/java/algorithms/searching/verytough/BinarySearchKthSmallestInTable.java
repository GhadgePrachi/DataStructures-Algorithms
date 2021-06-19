package algorithms.searching.verytough;

public class BinarySearchKthSmallestInTable {
    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //count => no of elements in multiplication table <= mid
            int count = count(m, n, mid);
            if(count < k) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return left;
    }

    private int count(int m, int n, int target) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(target / i, n);
        }
        return count;
    }
}
