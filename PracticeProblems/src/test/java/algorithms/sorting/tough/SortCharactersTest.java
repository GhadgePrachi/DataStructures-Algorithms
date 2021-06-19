package algorithms.sorting.tough;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortCharactersTest {
    @Test
    public void testSortStringsSuccess() {
        List<String> words = new ArrayList<>( Arrays.asList("art", "tar", "rat", "ant", "cat", "tan", "act", "tac"));
        List<List<String>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(Arrays.asList("art", "tar", "rat")));
        expected.add(new ArrayList<>(Arrays.asList("ant", "tan")));
        expected.add(new ArrayList<>(Arrays.asList("act", "tac", "cat")));
        List<List<String>> output = SortStrings.groupAnagrams(words);
        for (List<String> innerList : output) {
            Collections.sort(innerList);
        }
        Assert.assertTrue(compare(expected, output));
    }

    public boolean compare(List<List<String>> expected, List<List<String>> output) {
        if (expected.size() != output.size()) {
            return false;
        }
        for (List<String> group : expected) {
            Collections.sort(group);
            if (!output.contains(group)) {
                return false;
            }
        }
        return true;
    }
}
