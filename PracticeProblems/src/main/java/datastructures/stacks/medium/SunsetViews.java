package datastructures.stacks.medium;

import java.util.ArrayList;
import java.util.Collections;

public class SunsetViews {
    public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        ArrayList<Integer> buildingsWithSunsetViews = new ArrayList<>();
        int index = 0, step = 1;//WEST
        if (direction.equals("EAST")) {
            index = buildings.length - 1;
            step = -1;
        }

        int runningMaxHeight = 0;
        while (index >= 0 && index <= buildings.length - 1) {
            int building = buildings[index];
            if (building > runningMaxHeight) {
                buildingsWithSunsetViews.add(index);
                runningMaxHeight = building;
            }
            index += step;
        }

        if (direction.equals("EAST")) {
            Collections.reverse(buildingsWithSunsetViews);
        }
        return buildingsWithSunsetViews;
    }
}
