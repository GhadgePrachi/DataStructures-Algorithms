package datastructures.arrays.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumThree {
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        List<Integer[]> threeSum = new ArrayList<>();
        for (int i = 0; i < array.length - 2; i++){
            int left = i+1, right = array.length-1;
            while(left < right){
                int currentSum = array[i] + array[left] + array[right];
                if (currentSum == targetSum){
                    threeSum.add(new Integer[]{array[i], array[left], array[right]});
                    left++;
                    right--;
                }else if (currentSum < targetSum){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return threeSum;
    }
}
