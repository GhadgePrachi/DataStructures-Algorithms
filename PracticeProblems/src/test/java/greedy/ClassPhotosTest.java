package greedy;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ClassPhotosTest {
    @Test
    public void testClassPhotosSuccess() {
        ArrayList<Integer> redShirtHeights = new ArrayList<Integer>(Arrays.asList(5, 8, 1, 3, 4));
        ArrayList<Integer> blueShirtHeights = new ArrayList<Integer>(Arrays.asList(6, 9, 2, 4, 5));
        Assert.assertTrue(new ClassPhotos().classPhotos(redShirtHeights, blueShirtHeights));
    }
}
