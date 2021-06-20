package algorithms.dynamicprogramming.tough;

public class MaxSumSubMatrix {
    public int maximumSumSubMatrix(int[][] matrix, int size) {
        int[][] sumThrough = precomputeSums(matrix);
        int maxSum = Integer.MIN_VALUE;

        for (int row1 = size - 1; row1 < matrix.length; row1++) {
            for (int col1 = size - 1; col1 < matrix[0].length; col1++) {
                int sum = sum(sumThrough, row1 - size + 1, col1 - size + 1, row1, col1);
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    public static int[][] precomputeSums(int[][] matrix) {
        int[][] sumThrough = new int[matrix.length][matrix[0].length];
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                int left = c > 0 ? sumThrough[r][c - 1] : 0;
                int top = r > 0 ? sumThrough[r - 1][c] : 0;
                int overlap = r > 0 && c > 0 ? sumThrough[r - 1][c - 1] : 0;
                sumThrough[r][c] = left + top - overlap + matrix[r][c];
            }
        }
        return sumThrough;
    }

    public static int sum(int[][] sumThrough, int r1, int c1, int r2, int c2) {
        int topAndLeft = r1 > 0 && c1 > 0 ? sumThrough[r1 - 1][c1 - 1] : 0;
        int left = c1 > 0 ? sumThrough[r2][c1 - 1] : 0;
        int top = r1 > 0 ? sumThrough[r1 - 1][c2] : 0;
        int full = sumThrough[r2][c2];
        return full - left - top + topAndLeft;
    }
}
