package algorithms.searching.verytough;

public class BinarySearchKthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        int left = matrix[0][0], right = matrix[matrix.length - 1][matrix.length - 1];
        while(left <= right){
            int mid = left + (right-left) / 2;
            //count =>no of elements in matrix <= mid
            int count = count(matrix, mid);
            if(count < k) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return left;
    }

    private int count(int[][] matrix, int target){
        int count = 0;
        int row = 0, col = matrix.length - 1;
        while(row < matrix.length && col >= 0){
            if(matrix[col][row] <= target){
                count += col+1;
                row++;
            }else{
                col--;
            }
        }
        return count;
    }
}
