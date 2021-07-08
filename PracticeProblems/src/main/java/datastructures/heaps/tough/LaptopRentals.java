package datastructures.heaps.tough;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class LaptopRentals {
    public int laptopRentals(ArrayList<ArrayList<Integer>> times) {
        Collections.sort(times, (a, b)->Integer.compare(a.get(0),b.get(0)));
        PriorityQueue<ArrayList<Integer>> timesWhenLaptopIsUsed = new PriorityQueue<>((a, b)->Integer.compare(a.get(1),b.get(1)));
        for (int i = 0; i < times.size(); i++) {
            if (!timesWhenLaptopIsUsed.isEmpty() && times.get(i).get(0) >= timesWhenLaptopIsUsed.peek().get(1)) {
                timesWhenLaptopIsUsed.poll();
            }
            timesWhenLaptopIsUsed.offer(times.get(i));
        }
        return timesWhenLaptopIsUsed.size();
    }
}
