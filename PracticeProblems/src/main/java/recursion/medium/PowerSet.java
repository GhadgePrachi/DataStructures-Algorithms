package recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public static List<List<Integer>> powerSet(List<Integer> array) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        powerSet(array,0, combination, combinations);
        return combinations;
    }

    public static void powerSet(List<Integer> array, int index, List<Integer> combination, List<List<Integer>> combinations) {
        if (index == array.size()) {
            combinations.add(new ArrayList<>(combination));
            return;
        }

        combination.add(array.get(index));
        powerSet(array, index + 1, combination, combinations);//with
        combination.remove(combination.size() - 1);
        powerSet(array, index + 1, combination, combinations);//without
    }
}
