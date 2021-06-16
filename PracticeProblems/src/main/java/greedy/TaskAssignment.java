package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class TaskAssignment {
    public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
        HashMap<Integer, List<Integer>> indexedTasks = getMap(tasks);
        Collections.sort(tasks);
        ArrayList<ArrayList<Integer>> kPairs = new ArrayList<>();
        int left = 0, right = tasks.size() - 1;
        while (left < right) {
            ArrayList<Integer> indicesLeft = (ArrayList<Integer>) indexedTasks.get(tasks.get(left));
            ArrayList<Integer> indicesRight = (ArrayList<Integer>) indexedTasks.get(tasks.get(right));
            ArrayList<Integer> pairIndices = new ArrayList<>();
            pairIndices.add(indicesLeft.remove(indicesLeft.size() - 1));
            pairIndices.add(indicesRight.remove(indicesRight.size() - 1));
            kPairs.add(pairIndices);
            left += 1;
            right -= 1;
        }
        return kPairs;
    }

    public HashMap<Integer, List<Integer>> getMap(ArrayList<Integer> tasks) {
        HashMap<Integer, List<Integer>> indexedElements = new HashMap<>();
        List<Integer> indices;
        for (int i = 0; i < tasks.size(); i++) {
            indices = indexedElements.getOrDefault(tasks.get(i), new ArrayList<>());
            indices.add(i);
            indexedElements.put(tasks.get(i), indices);
        }
        return indexedElements;
    }
}
