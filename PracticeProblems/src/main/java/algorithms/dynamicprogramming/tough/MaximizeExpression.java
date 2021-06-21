package algorithms.dynamicprogramming.tough;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximizeExpression {
    public int maximizeExpression(int[] array) {
        if(array.length < 4) {
            return 0;
        }
        ArrayList<Integer> maxOfA = new ArrayList<>(Arrays.asList(array[0]));
        ArrayList<Integer> maxOfAMinusB = new ArrayList<>(Arrays.asList(Integer.MIN_VALUE));
        ArrayList<Integer> maxOfAMinusBPlusC = new ArrayList<>(Arrays.asList(Integer.MIN_VALUE, Integer.MIN_VALUE));
        ArrayList<Integer> maxOfAMinusBPlusCMinusD = new ArrayList<>(Arrays.asList(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE));
        for (int i = 1; i < array.length; i++) {
            int currentMax = Math.max(maxOfA.get(i-1), array[i]);
            maxOfA.add(currentMax);
        }
        for (int i = 1; i < array.length; i++) {
            int currentMax = Math.max(maxOfAMinusB.get(i-1), maxOfA.get(i-1) - array[i]);
            maxOfAMinusB.add(currentMax);
        }
        for (int i = 2; i < array.length; i++) {
            int currentMax = Math.max(maxOfAMinusBPlusC.get(i-1), maxOfAMinusB.get(i-1) + array[i]);
            maxOfAMinusBPlusC.add(currentMax);
        }
        for (int i = 3; i < array.length; i++) {
            int currentMax = Math.max(maxOfAMinusBPlusCMinusD.get(i-1), maxOfAMinusBPlusC.get(i-1) - array[i]);
            maxOfAMinusBPlusCMinusD.add(currentMax);
        }
        return maxOfAMinusBPlusCMinusD.get(maxOfAMinusBPlusCMinusD.size() - 1);
    }
}
