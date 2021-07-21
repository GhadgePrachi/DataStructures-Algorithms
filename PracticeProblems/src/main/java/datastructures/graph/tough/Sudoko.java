package datastructures.graph.tough;

import java.util.ArrayList;

public class Sudoko {
    public ArrayList<ArrayList<Integer>> solveSudoku(ArrayList<ArrayList<Integer>> board) {
        solveSudoku(0, 0, board);
        return board;
    }

    public static boolean solveSudoku (int row, int col, ArrayList<ArrayList<Integer>> board) {
        if (col == board.get(row).size()) {
            row++;
            col = 0;
        }

        if (row == board.size()) {
            return true;
        }

        if (board.get(row).get(col) == 0) {
            for (int digit = 1; digit < 10; digit++) {
                if (isValidAtPosition (digit, row, col, board)) {
                    board.get(row).set(col, digit);
                    if (solveSudoku (row, col + 1, board)) {
                        return true;
                    }
                }
            }

            board.get(row).set(col,0);
            return false;
        } else {
            return solveSudoku(row, col + 1, board);
        }
    }

    public static boolean isValidAtPosition (int val, int currentRow, int currentCol, ArrayList<ArrayList<Integer>> board) {
        //Validate cols
        for (int col = 0; col < board.get(0).size(); col++) {
            if (board.get(currentRow).get(col) == val) {
                return false;
            }
        }

        //Validate rows
        for (int row = 0; row < board.size(); row++) {
            if (board.get(row).get(currentCol) == val) {
                return false;
            }
        }

        //Validate subgrid
        int subgridRowStart = (currentRow / 3 ) * 3;
        int subgridColStart = (currentCol / 3 ) * 3;
        for (int subgridRow = 0; subgridRow < 3; subgridRow++) {
            for (int subgridCol = 0; subgridCol < 3; subgridCol++) {
                if (board.get(subgridRowStart + subgridRow).get(subgridColStart + subgridCol) == val) {
                    return false;
                }
            }
        }
        return true;
    }
}
