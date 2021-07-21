package datastructures.graph.medium;

import java.util.LinkedList;
import java.util.Queue;

public class RemoveIslands {
    public static int[] directionRow = {1, -1, 0, 0};
    public static int[] directionCol = {0, 0, 1, -1};

    public int[][] removeIslands(int[][] matrix) {
        Queue<Integer[]> nextToVisit = new LinkedList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        getBorderOnes(matrix, nextToVisit, visited);
        searchAndMark(matrix, nextToVisit, visited);

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 2)
                    matrix[row][col] = 1;
                else if (matrix[row][col] == 1)
                    matrix[row][col] = 0;
            }
        }
        return matrix;
    }

    public static void getBorderOnes(int[][] matrix, Queue<Integer[]> nextToVisit, boolean[][] visited) {
        for (int col = 0; col < matrix[0].length; col++) {
            int row = 0;
            if (matrix[row][col] == 1) {
                nextToVisit.offer(new Integer[] {row, col});
                visited[row][col] = true;
            }

            row = matrix.length - 1;
            if (matrix[row][col] == 1) {
                nextToVisit.offer(new Integer[] {row, col});
                visited[row][col] = true;
            }
        }

        for (int row = 1; row < matrix.length - 1; row++) {
            int col = 0;
            if (matrix[row][col] == 1) {
                nextToVisit.offer(new Integer[] {row, col});
                visited[row][col] = true;
            }

            col = matrix[0].length - 1;
            if (matrix[row][col] == 1) {
                nextToVisit.offer(new Integer[] {row, col});
                visited[row][col] = true;
            }
        }
    }

    public static void searchAndMark(int[][] matrix, Queue<Integer[]> nextToVisit, boolean[][] visited) {
        while (!nextToVisit.isEmpty()) {
            Integer[] matrixCell = nextToVisit.poll();
            matrix[matrixCell[0]][matrixCell[1]] = 2;

            for (int direction = 0; direction < 4; direction++) {
                int nextRow = matrixCell[0] + directionRow[direction];
                int nextCol = matrixCell[1] + directionCol[direction];

                if (nextRow >= 0 && nextRow < matrix.length &&
                        nextCol >= 0 && nextCol < matrix[0].length &&
                        !visited[nextRow][nextCol] && matrix[nextRow][nextCol] == 1) {
                    nextToVisit.offer(new Integer[] {nextRow, nextCol});
                    visited[nextRow][nextCol] = true;
                }
            }
        }
    }
}
