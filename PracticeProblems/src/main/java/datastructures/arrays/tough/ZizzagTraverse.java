package datastructures.arrays.tough;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZizzagTraverse {
    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        List<Integer> spiralPrint = new ArrayList<>();
        boolean down = false;

        int firstRow = 0;
        for (int col = 0; col < array.get(firstRow).size(); col++){
            List<Integer> diagonals = getDiagonals(array, firstRow,col);
            if (down){
                Collections.reverse(diagonals);
            }
            down = !down;
            spiralPrint.addAll(diagonals);
        }

        int lastColumn = array.get(firstRow).size() - 1;
        for (int row = 1; row < array.size(); row++){
            List<Integer> diagonals = getDiagonals(array,row,lastColumn);
            if (down){
                Collections.reverse(diagonals);
            }
            down = !down;
            spiralPrint.addAll(diagonals);
        }
        return spiralPrint;
    }

    public static List<Integer> getDiagonals(List<List<Integer>> array, int row, int col){
        List<Integer> diagonalElements = new ArrayList<>();
        while(row < array.size()  && col >= 0){
            diagonalElements.add(array.get(row).get(col));
            row++;
            col--;
        }
        return diagonalElements;
    }
}
