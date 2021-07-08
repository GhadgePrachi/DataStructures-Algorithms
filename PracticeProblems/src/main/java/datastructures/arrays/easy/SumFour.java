package datastructures.arrays.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SumFour {
    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        HashMap<Integer, List<Integer[]>> twoPairSum = new HashMap<>();
        List<Integer[]> quadraplets = new ArrayList<>();
        for (int i = 1; i < array.length-1; i++){
            for (int j = i+1; j < array.length; j++){
                int currentSum = array[i] + array[j];
                int difference = targetSum - currentSum;
                if (twoPairSum.containsKey(difference)){
                    for (Integer[] pair : twoPairSum.get(difference)){
                        Integer[] quadraplet = {pair[0],pair[1],array[i],array[j]};
                        quadraplets.add(quadraplet);
                    }
                }
            }
            for (int k = 0; k < i; k++){
                int currentSum = array[i] + array[k];
                Integer[] pair = {array[i], array[k]};
                if (!twoPairSum.containsKey(currentSum)){
                    List<Integer[]> pairs = new ArrayList<>();
                    pairs.add(pair);
                    twoPairSum.put(currentSum, pairs);
                } else {
                    twoPairSum.get(currentSum).add(pair);
                }
            }
        }
        return quadraplets;
    }
}
