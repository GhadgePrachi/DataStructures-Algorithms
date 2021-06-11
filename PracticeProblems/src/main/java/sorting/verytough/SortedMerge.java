package sorting.verytough;

public class SortedMerge {
    public static int[] sortedMerge(int[] arrayOne, int[] arrayTwo,int lastOne , int lastTwo){
        int mergedEndIndex = lastOne + lastTwo - 1;
        int indexOne = lastOne - 1;
        int indexTwo = lastTwo - 1;

        while(indexTwo >= 0) {
            if(indexOne >= 0 && arrayOne[indexOne] > arrayTwo[indexTwo]) {
                arrayOne[mergedEndIndex] = arrayOne[indexOne--];
            }else{
                arrayOne[mergedEndIndex] = arrayTwo[indexTwo--];
            }
            mergedEndIndex--;
        }
        return arrayOne;
    }
}
