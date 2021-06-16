package recursion.easy;

import java.util.ArrayList;
import java.util.List;

public class ProductSum {
    public static int productSum(List<Object> array) {
        if (array.size() == 0) {
            return -1;
        }
        return productSum(array, 1);
    }

    public static int productSum(List<Object> array, int depth) {
        int sum = 0;
        for (Object o : array) {
            if (o instanceof ArrayList) {
                ArrayList<Object> sublist = (ArrayList<Object>) o;
                sum += productSum(sublist, depth + 1);
            } else {
                sum += (int) o;
            }
        }
        return sum * depth;
    }
}
