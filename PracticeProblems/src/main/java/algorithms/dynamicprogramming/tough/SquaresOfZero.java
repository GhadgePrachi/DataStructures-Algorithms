package algorithms.dynamicprogramming.tough;

import java.util.List;

public class SquaresOfZero {
    public static boolean squareOfZeroes(List<List<Integer>> matrix) {
        SquareCell[][] processed = processSquare(matrix);
        int N = matrix.size();

        for (int i = N; i > 1; i--) {
            for (int row = 0; row < processed.length - i + 1; row++) {
                for (int col = 0; col < processed.length - i + 1; col++) {
                    if (isSquare(processed, row, col, i)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean isSquare(SquareCell[][] matrix, int row, int col, int size) {
        SquareCell topLeft = matrix[row][col];
        SquareCell topRight = matrix[row][col + size - 1];
        SquareCell bottomLeft = matrix[row + size - 1][col];
        if (topLeft.zerosRight < size) { // Check top edge
            return false;
        }
        if (topLeft.zerosBelow < size) { // Check left edge
            return false;
        }
        if (topRight.zerosBelow < size) { // Check right edge
            return false;
        }
        if (bottomLeft.zerosRight < size) { // Check bottom edge
            return false;
        }
        return true;
    }
    public  static SquareCell[][] processSquare(List<List<Integer>> matrix) {
        SquareCell[][] processed = new SquareCell[matrix.size()][matrix.get(0).size()];

        for (int r = matrix.size() - 1; r >= 0; r--) {
            for (int c = matrix.get(r).size() - 1; c >= 0; c--) {
                int rightZeros = 0;
                int belowZeros = 0;
                if (matrix.get(r).get(c) == 0) { // only need to process if it's a black cell
                    rightZeros++;
                    belowZeros++;
                    if (c < matrix.size() - 1) { // next column over is on same row
                        SquareCell previous = processed[r][c + 1];
                        rightZeros += previous.zerosRight;
                    }
                    if (r < matrix.size() - 1) {
                        SquareCell previous = processed[r + 1][c];
                        belowZeros += previous.zerosBelow;
                    }
                }
                processed[r][c] = new SquareCell(rightZeros, belowZeros);
            }
        }
        return processed;
    }

    public static class SquareCell {
        public int zerosRight = 0;
        public int zerosBelow = 0;

        public SquareCell(int right, int below) {
            zerosRight = right;
            zerosBelow = below;
        }

        public void setZerosRight(int right) {
            zerosRight = right;
        }

        public void setZerosBelow(int below) {
            zerosBelow = below;
        }
    }
}
