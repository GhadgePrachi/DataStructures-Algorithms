package datastructures.stacks.medium;

import java.util.Stack;

public class MinMaxStack {
    Stack<Integer> elements = new Stack<>();
    Stack<Integer> minElements = new Stack<>();
    Stack<Integer> maxElements = new Stack<>();

    public int peek() {
        return elements.peek();
    }

    public int pop() {
        if (minElements.peek().equals(elements.peek()) ){
            minElements.pop();
        }

        if (maxElements.peek().equals(elements.peek())) {
            maxElements.pop();
        }

        return elements.pop();
    }

    public void push(Integer number) {
        if (maxElements.isEmpty() || maxElements.peek() <= number)
            maxElements.push(number);

        if (minElements.isEmpty() || minElements.peek() >= number)
            minElements.push(number);

        elements.push(number);
    }

    public int getMin() {
        return minElements.peek();
    }

    public int getMax() {
        return maxElements.peek();
    }
}
