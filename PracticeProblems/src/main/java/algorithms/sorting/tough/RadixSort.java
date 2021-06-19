package algorithms.sorting.tough;

import java.util.ArrayList;
import java.util.Collections;

public class RadixSort {
    public static ArrayList<Integer> radixSort(ArrayList<Integer> array) {
        if (array.size() == 0) {
            return array;
        }

        int max = Collections.max(array);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(array, array.size(), exp);
        }
        return array;
    }

    public static void countSort(ArrayList<Integer> array, int n, int exp) {
        int sorted[] = new int[n];
        int count[] = new int[10];

        for (int i = 0; i < n; i++) {
            count[(array.get(i) / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            sorted[count[(array.get(i) / exp) % 10] - 1] = array.get(i);
            count[(array.get(i) / exp) % 10]--;
        }

        for (int i = 0; i < n; i++) {
            array.set(i, sorted[i]);
        }
    }
}
