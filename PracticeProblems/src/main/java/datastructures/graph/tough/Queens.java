package datastructures.graph.tough;

public class Queens {
    public int nonAttackingQueens(int n) {
        int[] columns = new int[n];
        return getNumberOfNonAttackingQueenPlacements(0, columns, n);
    }

    public int getNumberOfNonAttackingQueenPlacements(int row, int[] columns, int boardSize) {
        if (row == boardSize) {
            return 1;
        }

        int validCounts = 0;
        for (int col = 0; col < boardSize; col++) {
            if (isValidAtPosition(row, col, columns)) {
                columns[row] = col;
                validCounts += getNumberOfNonAttackingQueenPlacements(row + 1, columns, boardSize);
            }
        }
        return validCounts;
    }

    public static boolean isValidAtPosition (int currentRow, int currentCol, int[] columns) {
        for (int previousRow = 0; previousRow < currentRow; previousRow++) {
            int previousCol = columns[previousRow];

            //Validate column
            if (previousCol == currentCol) {
                return false;
            }

            //Validate diagonal
            if (Math.abs(previousCol - currentCol) == Math.abs(previousRow - currentRow)) {
                return false;
            }
        }
        return true;
    }
}
