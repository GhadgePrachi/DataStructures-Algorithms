package datastructures.arrays.easy;

public class Divide {
    public int findSplitPoint(int arr[], int n) {
        int leftSum = 0, rightSum = 0;
        for (int i = 0 ; i < n ; i++) {
            leftSum += arr[i];
        }
        for (int i = n-1; i >= 0; i--) {
            rightSum += arr[i];
            leftSum -= arr[i] ;
            if (rightSum == leftSum) {
                return i;
            }
        }
        return -1;
    }
}
