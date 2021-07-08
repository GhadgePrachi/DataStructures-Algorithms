package datastructures.stacks.medium;

import java.util.Stack;

public class SortStack {
    public static void sort(Stack<Integer> stack) {
        Stack<Integer> auxiliaryStack = new Stack<>();
        while (!stack.isEmpty()) {
            int tmp = stack.pop();
            while (!auxiliaryStack.isEmpty() && auxiliaryStack.peek() > tmp) {
                stack.push(auxiliaryStack.pop());
            }
            auxiliaryStack.push(tmp);
        }

        while (!auxiliaryStack.isEmpty()) {
            stack.push(auxiliaryStack.pop());
        }
    }
}
