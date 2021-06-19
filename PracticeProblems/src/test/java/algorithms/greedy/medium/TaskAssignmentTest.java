package algorithms.greedy.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TaskAssignmentTest {
    @Test
    public void testTaskAssignmentSuccess() {
        ArrayList<Integer> tasks = new ArrayList<>(Arrays.asList(1, 3, 5, 3, 1, 4));
        int k = 3;
        ArrayList<ArrayList<Integer>> expected = new ArrayList<>();
        ArrayList<Integer> subarr = new ArrayList<Integer>(Arrays.asList(4, 2));
        ArrayList<Integer> subarr2 = new ArrayList<Integer>(Arrays.asList(0, 5));
        ArrayList<Integer> subarr3 = new ArrayList<Integer>(Arrays.asList(3, 1));
        expected.add(subarr);
        expected.add(subarr2);
        expected.add(subarr3);
        Assert.assertEquals(expected, new TaskAssignment().taskAssignment(k, tasks));
    }
}
