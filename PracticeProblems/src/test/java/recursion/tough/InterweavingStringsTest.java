package recursion.tough;

import org.junit.Assert;
import org.junit.Test;

public class InterweavingStringsTest {
    @Test
    public void testInterweavingStringsSuccess() {
        String one = "positive-relaxed-";
        String two = "have-and-goals";
        String three = "have-positive-and-relaxed-goals";
        Assert.assertTrue(InterweavingStrings.interweavingStrings(one, two, three));
    }

    @Test
    public void testInterweavingStringsFail() {
        String one = "can-";
        String two = "you-it";
        String three = "you-can-do-it";
        Assert.assertFalse(InterweavingStrings.interweavingStrings(one, two, three));

        one = "can-do";
        two = "it-you-";
        three = "you-can-do-it";
        Assert.assertFalse(InterweavingStrings.interweavingStrings(one, two, three));

        one = "aacaaaa";
        two = "aaabaaa";
        three = "aaaaaacbaaaaaa";
        Assert.assertFalse(InterweavingStrings.interweavingStrings(one, two, three));
    }

}
