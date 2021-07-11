package datastructures.arrays.tough;

public class RotateMatrix {
    public static int[][] rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            return null;
        }
        int n = matrix.length;

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i]; // save top
                matrix[first][i] = matrix[last-offset][first]; // left -> top
                matrix[last-offset][first] = matrix[last][last - offset]; // bottom -> left
                matrix[last][last - offset] = matrix[i][last]; // right -> bottom
                matrix[i][last] = top; // // top -> right; right <- saved top
            }
        }
        return matrix;
    }
}
