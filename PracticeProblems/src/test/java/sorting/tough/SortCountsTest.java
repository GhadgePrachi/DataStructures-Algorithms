package sorting.tough;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortCountsTest {
    @Test
    public void testSortCountsSuccess() {
        List<String> book = new ArrayList<>( Arrays.asList("an", "a", "the", "the", "the", "for", "for", "for"));
        List<List<String>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(Arrays.asList("an", "a")));
        expected.add(new ArrayList<>(Arrays.asList("the", "for")));
        List<List<String>> output = SortCounts.sortFrequencies(book);
        for (List<String> inner : output) {
            Collections.sort(inner);
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
