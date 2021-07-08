package datastructures.arrays.tough;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {
    public static List<Integer> spiralTraverse(int[][] array) {
        List<Integer> spiralPrint = new ArrayList<>();
        int startRow = 0, endRow = array.length - 1;
        int startColumn = 0, endColumn = array[0].length -1;
        while(startRow <= endRow && startColumn <= endColumn){
            for (int c = startColumn; c <= endColumn; c++) {
                spiralPrint.add(array[startRow][c]);
            }
            startRow++;

            for(int r = startRow; r <= endRow; r++) {
                spiralPrint.add(array[r][endColumn]);
            }
            endColumn--;

            if(startRow <= endRow){
                for(int c = endColumn ; c >= startColumn; c--) {
                    spiralPrint.add(array[endRow][c]);
                }
                endRow--;
            }

            if(startColumn <= endColumn){
                for (int r = endRow; r >= startRow; r--) {
                    spiralPrint.add(array[r][startColumn]);
                }
                startColumn++;
            }
        }
        return spiralPrint;
    }
}
