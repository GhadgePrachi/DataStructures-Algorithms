package datastructures.graph.medium;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumPasses {
    public static int[] directionRow = {1, -1, 0, 0};
    public static int[] directionCol = {0, 0, 1, -1};

    public int minimumPasses(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        Queue<Integer[]> nextToVisit = new LinkedList<>();
        getPositives(matrix, nextToVisit, visited);
        int passes = searchAndFlip(matrix, nextToVisit, visited);

        if (!containsNegative(matrix)) {
            return passes;
        } else {
            return -1;
        }
    }

    public static void getPositives(int[][] matrix, Queue<Integer[]> nextToVisit, boolean[][] visited) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] > 0) {
                    nextToVisit.offer(new Integer[] {row, col});
                    visited[row][col] = true;
                }
            }
        }
    }

    public static int searchAndFlip(int[][] matrix, Queue<Integer[]> nextToVisit, boolean[][] visited) {
        int passes = 0;
        while (nextToVisit.size() > 0) {
            int size = nextToVisit.size();
            for (int i = 0; i < size; i++) {
                Integer[] matrixCell = nextToVisit.poll();
                int row = matrixCell[0];
                int col = matrixCell[1];
                for (int direction = 0; direction < 4; direction++) {
                    int nextRow = row + directionRow[direction];
                    int nextCol = col + directionCol[direction];

                    if (nextRow >= 0 && nextRow < matrix.length && nextCol >= 0 && nextCol < matrix[0].length && !visited[nextRow][nextCol]) {
                        if (matrix[nextRow][nextCol] < 0) {
                            matrix[nextRow][nextCol] *= -1;
                            nextToVisit.offer(new Integer[] {nextRow, nextCol});
                            visited[nextRow][nextCol] = true;
                        }
                    }
                }
            }
            passes += 1;
        }
        return passes - 1;
    }

    public static boolean containsNegative(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                if (value < 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
