package datastructures.arrays.easy;

import java.util.Arrays;
import java.util.HashSet;

public class SumTwo {
    public static int[] twoNumberSum(int[] array, int targetSum) {
        HashSet<Integer> elements = new HashSet<>();
        for(int i = 0; i < array.length; i++){
            int diff = targetSum - array[i];
            if (elements.contains(diff)){
                return new int[]{diff,array[i]};
            }
            elements.add(array[i]);
        }
        return new int[0];
    }
    public static int[] twoNumberSumGreedy(int[] array, int targetSum) {
        Arrays.sort(array);
        int left = 0, right = array.length-1;
        while(left < right){
            int currentSum = array[left] + array[right];
            if (currentSum == targetSum){
                return new int[]{array[left], array[right]};
            }else if (currentSum < targetSum){
                left++;
            }else{
                right--;
            }
        }
        return new int[0];
    }
}
