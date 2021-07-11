package datastructures.arrays.easy;

import java.util.ArrayList;
import java.util.HashMap;

public class Calculate {
    public static int HOME_TEAM_IDX = 0;
    public static int AWAY_TEAM_IDX = 1;
    public static int HOME_TEAM_WON = 1;
    public static int AWAY_TEAM_WON = 0;
    public static int WIN_POINTS = 3;

    public String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        String bestTeam = "";
        HashMap<String, Integer> scores = new HashMap<>();
        scores.put(bestTeam, 0);
        for (int i = 0; i < results.size(); i++) {
            int result = results.get(i);
            String winningTeam = "";
            if (result == HOME_TEAM_WON) {
                winningTeam = competitions.get(i).get(HOME_TEAM_IDX);
            } else if (result == AWAY_TEAM_WON) {
                winningTeam = competitions.get(i).get(AWAY_TEAM_IDX);
            }
            scores.put(winningTeam, scores.getOrDefault(winningTeam, 0) + WIN_POINTS);

            if (scores.get(winningTeam) > scores.get(bestTeam)) {
                bestTeam = winningTeam;
            }
        }
        return bestTeam;
    }
}
