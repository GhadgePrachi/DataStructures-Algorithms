package datastructures.arrays.medium;

import java.util.List;

public class MoveElementToEnd {
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int j = 0;
        for (int i = 0; i < array.size(); i++){
            if (array.get(i) != toMove){
                swap(i, j, array);
                j++;
            }
        }
        return array;
    }

    public static void swap(int i, int j, List<Integer> array){
        int temp = array.get(i);
        array.set(i,array.get(j));
        array.set(j,temp);
    }
}
