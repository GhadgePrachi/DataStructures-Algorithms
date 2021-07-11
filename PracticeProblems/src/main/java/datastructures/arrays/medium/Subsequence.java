package datastructures.arrays.medium;

import java.util.List;

public class Subsequence {
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int j = 0;
        for (int i = 0; i < array.size(); i++) {
            if (j < sequence.size() && sequence.get(j) == array.get(i)) {
                j++;
                if (j == sequence.size()) {
                    break;
                }
            }
        }
        return j == sequence.size();
    }
}
