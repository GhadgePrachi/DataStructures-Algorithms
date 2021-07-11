package datastructures.arrays.tough;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZizzagTraverse {
    public static List<Integer> zigzagTraverse(List<List<Integer>> matrix) {
        List<Integer> zizizagPrint = new ArrayList<>();
        boolean down = false;

        int firstRow = 0;
        for (int col = 0; col < matrix.get(firstRow).size(); col++) {
            List<Integer> diagonalElements = getDiagonals(matrix, firstRow,col);
            if (down) {
                Collections.reverse(diagonalElements);
            }
            down = !down;
            zizizagPrint.addAll(diagonalElements);
        }

        int lastColumn = matrix.get(firstRow).size() - 1;
        for (int row = 1; row < matrix.size(); row++) {
            List<Integer> diagonalElements = getDiagonals(matrix,row,lastColumn);
            if (down) {
                Collections.reverse(diagonalElements);
            }
            down = !down;
            zizizagPrint.addAll(diagonalElements);
        }
        return zizizagPrint;
    }

    public static List<Integer> getDiagonals(List<List<Integer>> array, int row, int col){
        List<Integer> diagonalElements = new ArrayList<>();
        while (row < array.size()  && col >= 0) {
            diagonalElements.add(array.get(row).get(col));
            row++;
            col--;
        }
        return diagonalElements;
    }
}
