package datastructures.graph.tough;

import java.util.ArrayList;
import java.util.List;

public class PondSize {
    public static int[] directionRow = {1, -1, 0, 0};
    public static int[] directionCol = {0, 0, 1, -1};

    public static List<Integer> riverSizes(int[][] matrix) {
        List<Integer> riverSizes = new ArrayList<Integer>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 1 && !visited[row][col]) {
                    int riverSize = search(row, col, matrix, visited);
                    riverSizes.add(riverSize);
                }
            }
        }
        return riverSizes;
    }

    public static int search(int row, int col, int[][] matrix, boolean[][] visited) {
        if (row < 0 || row >= matrix.length ||
                col < 0 || col >= matrix[row].length ||
                visited[row][col] || matrix[row][col] == 0) {
            return 0;
        }

        visited[row][col] = true;

        int size = 1;
        for (int direction = 0; direction < 4; direction++) {
            int nextRow = row + directionRow[direction];
            int nextCol = col + directionCol[direction];
            size += search(nextRow, nextCol, matrix, visited);
        }
        return size;
    }
}
