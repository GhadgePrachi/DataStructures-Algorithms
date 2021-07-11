package datastructures.arrays.tough;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {
    public static List<Integer> spiralTraverse(int[][] matrix) {
        List<Integer> spiralSequence = new ArrayList<>();
        int startRow = 0, endRow = matrix.length - 1;
        int startColumn = 0, endColumn = matrix[0].length - 1;
        while(startRow <= endRow && startColumn <= endColumn) {
            for (int c = startColumn; c <= endColumn; c++) {
                spiralSequence.add(matrix[startRow][c]);
            }
            startRow++;

            for (int r = startRow; r <= endRow; r++) {
                spiralSequence.add(matrix[r][endColumn]);
            }
            endColumn--;

            if (startRow <= endRow) {
                for (int c = endColumn ; c >= startColumn; c--) {
                    spiralSequence.add(matrix[endRow][c]);
                }
                endRow--;
            }

            if (startColumn <= endColumn) {
                for (int r = endRow; r >= startRow; r--) {
                    spiralSequence.add(matrix[r][startColumn]);
                }
                startColumn++;
            }
        }
        return spiralSequence;
    }
}
