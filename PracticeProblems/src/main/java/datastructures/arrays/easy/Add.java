package datastructures.arrays.easy;

import java.util.*;

public class Add {
    /** Add Two Numbers **/
    public static int[] twoSum(int[] array, int targetSum) {
        HashSet<Integer> set = new HashSet<>();
        for(int element : array){
            int difference = targetSum - element;
            if (set.contains(difference)){
                return new int[] {difference, element};
            }
            set.add(element);
        }
        return new int[0];
    }

    public static int[] twoSumGreedy(int[] array, int targetSum) {
        Arrays.sort(array);
        int left = 0, right = array.length-1;
        while (left < right) {
            int currentSum = array[left] + array[right];
            if (currentSum == targetSum) {
                return new int[]{array[left], array[right]};
            } else if (currentSum < targetSum) {
                left++;
            } else {
                right--;
            }
        }
        return new int[0];
    }

    /** Add Three Numbers **/
    public static List<Integer[]> threeSum(int[] array, int targetSum) {
        Arrays.sort(array);
        List<Integer[]> threeSum = new ArrayList<>();
        for (int i = 0; i < array.length - 2; i++) {
            int left = i + 1, right = array.length - 1;
            while (left < right) {
                int currentSum = array[i] + array[left] + array[right];
                if (currentSum == targetSum) {
                    threeSum.add(new Integer[] {array[i], array[left], array[right]});
                    left++;
                    right--;
                } else if (currentSum < targetSum) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return threeSum;
    }

    /** Add Four Number **/
    public static List<Integer[]> fourSum(int[] array, int targetSum) {
        HashMap<Integer, List<Integer[]>> twoSum = new HashMap<>();
        List<Integer[]> quadruplets = new ArrayList<>();
        for (int i = 1; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int currentSum = array[i] + array[j];
                int difference = targetSum - currentSum;
                if (twoSum.containsKey(difference)) {
                    for (Integer[] pair : twoSum.get(difference)) {
                        Integer[] quadruplet = {pair[0], pair[1], array[i], array[j]};
                        quadruplets.add(quadruplet);
                    }
                }
            }
            for (int k = 0; k < i; k++) {
                int currentSum = array[i] + array[k];
                Integer[] pair = {array[i], array[k]};
                if (!twoSum.containsKey(currentSum)) {
                    List<Integer[]> pairs = new ArrayList<>();
                    pairs.add(pair);
                    twoSum.put(currentSum, pairs);
                } else {
                    twoSum.get(currentSum).add(pair);
                }
            }
        }
        return quadruplets;
    }
}
