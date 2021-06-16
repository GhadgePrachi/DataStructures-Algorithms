package recursion.tough;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class GenerateDivTagsTest {
    @Test
    public void testGenerateDivTagsSuccess() {
        int input = 3;
        ArrayList<String> expected = new ArrayList<>( Arrays.asList(
                                "<div><div><div></div></div></div>",
                                "<div><div></div><div></div></div>",
                                "<div><div></div></div><div></div>",
                                "<div></div><div><div></div></div>",
                                "<div></div><div></div><div></div>"));
        Assert.assertEquals(expected, new GenerateDivTags().generateDivTags(input));
    }
}
