package algorithms.recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> permutations = new ArrayList<>();
        getPermutations(array,0,permutations);
        return permutations;
    }

    public static void getPermutations(List<Integer> array, int index, List<List<Integer>> permutations) {
        if (index == array.size() - 1) {
            permutations.add(new ArrayList<>(array));
            return;
        }

        for (int i = index; i < array.size(); i++) {
            swap (array, i, index);
            getPermutations(array, index + 1, permutations);
            swap (array, i, index);
        }
    }

    public static void swap(List<Integer> array, int i, int j) {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }
}
