package datastructures.stacks.medium;

import java.util.*;

public class NextElement {
    /**Next Greatest Numbers in an Array**/
    public int[] nextGreaterElement(int[] arrayOne, int[] arrayTwo) {
        Stack<Integer> stack = new Stack<>();
        HashMap< Integer, Integer > map = new HashMap<>();
        int[] nextGreatestElement = new int[arrayOne.length];

        //Get next greatest for all numbers in arrayTwo
        for (int i = 0; i < arrayTwo.length; i++) {
            while (!stack.empty() && arrayTwo[i] > stack.peek()) {
                map.put(stack.pop(), arrayTwo[i]);
            }
            stack.push(arrayTwo[i]);
        }
        while (!stack.empty()) {
            map.put(stack.pop(), -1);
        }

        //Determine the next greater element of arrayOne in arrayTwo
        for (int i = 0; i < arrayOne.length; i++) {
            nextGreatestElement[i] = map.get(arrayOne[i]);
        }
        return nextGreatestElement;
    }

    /**Next Greatest Numbers in an Circular Array**/
    public int[] nextGreaterElement(int[] array) {
        int[] result = new int[array.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0 ; i < 2 * array.length - 1; i++) {
            int circularIndex = i % array.length;
            while (!stack.isEmpty() && array[circularIndex] > array[stack.peek()]) {
                int valueIndex = (int) stack.pop();
                if (result[valueIndex] == -1) {
                    result[valueIndex] = array[circularIndex];
                }
            }
            stack.push(circularIndex);
        }
        return result;
    }

    /**Next Smallest Number after Deleting K Digits**/
    //Assumption : k is always less than total digits in the number
    public String removeKDigitsToMakeSmallest(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && !stack.isEmpty() && num.charAt(i) < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }

        //Deleting remaining trailing digits to get smaller number
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        return constructNumberFromStack(stack);
    }

    private String constructNumberFromStack(Stack stack) {
        StringBuilder sb = new StringBuilder(stack.size());
        while (!stack.isEmpty()) {
            sb.insert(0,stack.pop());
        }

        //Deleting all leading 0's
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    /**Next greatest element by reordering fewer digits**/
    public int nextGreaterElement(int number) {
        char[] a = String.valueOf(number).toCharArray();

        //Get smaller digit as we iterate from the back
        int i = a.length - 1;
        while (i >= 1 && a[i] >= a[i - 1]) {
            i--;
        }
        if (i == 0) {
            return -1;//sorted
        }

        //Get next greatest for the element at index, where we stopped earlier and swap them
        int j = a.length - 1;
        while (j >= 0 && a[j] <= a[i - 1]) {
            j--;
        }
        swap(a, i - 1, j);

        //Reverse from the index + 1 (where we stopped) till n - 1
        reverse(a, i);
        try {
            return Integer.parseInt(new String(a));
        } catch (Exception e) {
            return -1;
        }
    }

    private void reverse(char[] a, int start) {
        int i = start, j = a.length - 1;
        while (i < j) {
            swap(a, i, j);
            i++;
            j--;
        }
    }

    private void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
