package datastructures.graph.easy;

import java.util.Arrays;

public class CelebrityJudge {
    /** Find Judge **/
    public int findJudge(int n, int[][] trust) {
        int[] count = new int[n];

        for (int[] edge:trust) {
            count[edge[0]]--; //outgoing edges
            count[edge[1]]++; //incoming edges
        }

        for (int i = 1; i <= n; i++) {
            if (count[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }

    /** Find Celebrity **/
    public static int CELEBRITY_ID;
    public void setCelebrity(int lower , int higher){
        CELEBRITY_ID = (int) (lower + Math.random()*(higher-lower+1));
    }

    public boolean knows(int i, int j){
        if (i == CELEBRITY_ID) {
            return false;
        } else {
            return true;
        }
    }

    public int findCelebrityNaive(int n) {
        int[] count = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (knows(i, j)) {
                        count[i]--; //outgoing edges
                        count[j]++; //incoming edges
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (count[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }

    public int findCelebrity(int n) {
        int celebrityCandidate = 0;
        for (int i = 0; i < n; i++) {
            if (knows(celebrityCandidate, i)) {
                celebrityCandidate = i;
            }
        }
        if (isCelebrity(celebrityCandidate, n)) {
            return celebrityCandidate;
        }
        return -1;
    }

    private boolean isCelebrity(int i, int n) {
        for (int j = 0; j < n; j++) {
            if (i != j) {
                if (knows(i, j) || !knows(j, i)) {
                    return false;
                }
            }
        }
        return true;
    }
}