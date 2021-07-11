package algorithms.recursion.tough;

import java.util.HashMap;

public class AmbiguousMeasurements {
    public boolean ambiguousMeasurements(int[][] measuringCups, int low, int high) {
        HashMap<String, Boolean> canMeasureUsingCups = new HashMap<String, Boolean>();
        return canMakeMeasures(measuringCups, low, high, canMeasureUsingCups);
    }

    public static boolean canMakeMeasures(int[][] measuringCups, int low, int high, HashMap<String, Boolean> canMeasureUsingCups) {
        String key = low + ":" + high;
        if (canMeasureUsingCups.containsKey(key)) {
            return canMeasureUsingCups.get(key);
        }

        if (low < 0 && high < 0) {
            return false;
        }

        if (low <= 0 && high >= 0) {
            return true;
        }

        boolean canMeasure = false;
        for (int[] measuringCup : measuringCups) {
            int currentLow = measuringCup[0];
            int currentHigh = measuringCup[1];
            if (canMakeMeasures (measuringCups, low - currentLow, high - currentHigh, canMeasureUsingCups)) {
                canMeasure = true;
                break;
            }
        }
        canMeasureUsingCups.put(key, canMeasure);
        return canMeasure;
    }
}
