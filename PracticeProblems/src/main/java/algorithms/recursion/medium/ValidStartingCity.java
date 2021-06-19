package algorithms.recursion.medium;

public class ValidStartingCity {
    public int validStartingCity(int[] distances, int[] fuel, int mpg) {
        for (int i = 0; i < distances.length; i++) {
            if (isPossible(i, distances, fuel, mpg)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isPossible(int startCity, int[] distances, int[] fuel, int mpg) {
        int currentCity = startCity;
        int currentFuel = 0;
        do {
            if (!canMove(distances[currentCity], fuel[currentCity] * mpg, currentFuel)) {
                return false;
            }
            currentFuel += (fuel[currentCity] * mpg);
            currentFuel -= distances[currentCity];

            currentCity = (currentCity + 1) % distances.length;
        } while (currentCity != startCity);

        return true;
    }

    public boolean canMove(int distance, int fuel, int currentFuel) {
        currentFuel = currentFuel + fuel - distance;
        if (currentFuel < 0) {
            return false;
        } else {
            return true;
        }
    }
}
