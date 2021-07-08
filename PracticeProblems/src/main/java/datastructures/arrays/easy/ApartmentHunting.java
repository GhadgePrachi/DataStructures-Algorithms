package datastructures.arrays.easy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ApartmentHunting {
    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
        int[][] minDistancesFromBlocks = new int[reqs.length][blocks.size()];
        for (int i = 0; i < reqs.length; i++) {
            minDistancesFromBlocks[i] = getMinDistances(blocks,reqs[i]);
        }
        int[] maxDistancesAtBlock = getMaxDistanceAtBlocks(blocks.size(),minDistancesFromBlocks);
        return getMinIndex(maxDistancesAtBlock);
    }

    public static int[] getMinDistances(List<Map<String, Boolean>> blocks, String req){
        int closestDistance = Integer.MAX_VALUE;
        int[] minDistances = new int[blocks.size()];
        for (int i = 0; i < blocks.size(); i++) {
            if (blocks.get(i).get(req))
                closestDistance = i;
            minDistances[i] = distanceBetween(i,closestDistance);
        }

        for (int i = blocks.size()-1; i >= 0; i--) {
            if (blocks.get(i).get(req))
                closestDistance = i;
            minDistances[i] = Math.min(minDistances[i],distanceBetween(i,closestDistance));
        }
        return minDistances;
    }

    public static int distanceBetween(int a, int b){
        return Math.abs(a-b);
    }

    public static int[] getMaxDistanceAtBlocks(int blockSize, int[][] minDistancesFromBlocks){
        int[] maxDistancesAtBlock = new int[blockSize];
        Arrays.fill(maxDistancesAtBlock, Integer.MIN_VALUE);
        for (int col = 0; col < minDistancesFromBlocks[0].length; col++) {
            for (int row = 0 ; row < minDistancesFromBlocks.length; row++) {
                maxDistancesAtBlock[col] = Math.max(maxDistancesAtBlock[col],minDistancesFromBlocks[row][col]);
            }
        }
        return maxDistancesAtBlock;
    }

    public static int getMinIndex(int[] array){
        int minIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[minIndex] > array[i])
                minIndex = i;
        }
        return minIndex;
    }
}
