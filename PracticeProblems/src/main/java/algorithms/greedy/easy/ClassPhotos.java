package algorithms.greedy.easy;

import java.util.ArrayList;
import java.util.Collections;

public class ClassPhotos {
    public boolean classPhotos(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        if (redShirtHeights.size() != blueShirtHeights.size())
            return false;

        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);

        if (redShirtHeights.get(0) > blueShirtHeights.get(0)) {
            return isGreater(redShirtHeights, blueShirtHeights);
        } else {
            return isGreater(blueShirtHeights, redShirtHeights);
        }
    }

    public boolean isGreater(ArrayList<Integer> arrayOne, ArrayList<Integer> arrayTwo) {
        for (int i = 0; i < arrayOne.size(); i++) {
            if (arrayOne.get(i) <= arrayTwo.get(i))
                return false;
        }
        return true;
    }
}
