package recursion.tough;

import java.util.HashMap;

public class AmbiguousMeasurements {
    public boolean ambiguousMeasurements(int[][] measuringCups, int low, int high) {
        HashMap<String, Boolean> canMeasureUsingCups = new HashMap<String, Boolean>();
        return canMakeMeasures(measuringCups, low, high, canMeasureUsingCups);
    }

    public static boolean canMakeMeasures(int[][] measuringCups, int low, int high, HashMap<String, Boolean> canMeasureUsingCups) {
        String key = String.valueOf(low) + ":" + String.valueOf(high);
        if (canMeasureUsingCups.containsKey(key)) {
            return canMeasureUsingCups.get(key);
        }

        if (low <= 0 && high <= 0)
            return false;

        boolean canMeasure = false;
        for (int[] measuringCup : measuringCups) {
            int currentLow = measuringCup[0];
            int currentHigh = measuringCup[1];
            if (low <= currentLow && high >= currentHigh) {
                canMeasure = true;
                break;
            }

            if (canMakeMeasures (measuringCups, low - currentLow, high - currentHigh, canMeasureUsingCups)) {
                canMeasure = true;
                break;
            }
        }
        canMeasureUsingCups.put(key, canMeasure);
        return canMeasure;
    }
}
