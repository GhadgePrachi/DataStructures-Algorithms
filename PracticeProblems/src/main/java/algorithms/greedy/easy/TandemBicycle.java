package algorithms.greedy.easy;

import java.util.Arrays;

public class TandemBicycle {
    public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);
        int redIndex = 0, blueIndex = 0;
        int redStep = 1, blueStep = 1;
        if (fastest) {
            blueIndex = blueShirtSpeeds.length - 1;
            blueStep = -1;
        }

        int total = 0, currentSpeed = 0;
        while (redIndex < redShirtSpeeds.length) {
            if (fastest) {
                currentSpeed = Math.max(redShirtSpeeds[redIndex], blueShirtSpeeds[blueIndex]);
            } else {
                currentSpeed = Math.max(redShirtSpeeds[redIndex], blueShirtSpeeds[blueIndex]);
            }
            total += currentSpeed;
            blueIndex += blueStep;
            redIndex += redStep;
        }
        return total;
    }
}
