package datastructures.graph.tough;

public class WaterStreams {
    public double[] waterfallStreams(double[][] matrix, int source) {
        double[] waterStreamValues = new double[matrix[0].length];
        searchAndCalculate(matrix, waterStreamValues, 0, source, 1.0);
        return multiply(waterStreamValues, 100);
    }

    public double[] multiply(double[] waterStreamValues, int val) {
        for (int i = 0; i < waterStreamValues.length; i++) {
            waterStreamValues[i] *= val;
        }
        return waterStreamValues;
    }

    public void searchAndCalculate(double[][] matrix, double[] waterStreamValues, int row, int col, double value) {
        if (row < 0 || row >= matrix.length  || col < 0 || col >= matrix[row].length || matrix[row][col] == 1.0) {
            return;
        }

        if (row == matrix.length - 1) {
            waterStreamValues[col] += value;
            return;
        }

        if (matrix[row + 1][col] == 0.0) { //No Block
            searchAndCalculate(matrix, waterStreamValues, row + 1, col, value);  //Go down
        } else {  //Block - Split into left, right
            value /= 2;

            int leftCol = col;
            while (leftCol >= 0 && matrix[row + 1][leftCol] == 1.0) {
                if (matrix[row][leftCol] == 1.0) {
                    break;
                }
                leftCol--;
            }
            searchAndCalculate(matrix, waterStreamValues, row, leftCol, value); //Go Left

            int rightCol = col;
            while (rightCol < matrix[0].length && matrix[row + 1][rightCol] == 1.0) {
                if (matrix[row][rightCol] == 1.0) {
                    return;
                }
                rightCol++;
            }
            searchAndCalculate(matrix, waterStreamValues, row, rightCol, value); //Go right
        }
    }
}
