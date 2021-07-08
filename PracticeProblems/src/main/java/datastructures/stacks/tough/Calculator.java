package datastructures.stacks.tough;

import java.util.Stack;

public class Calculator {
    public enum Operator {
        ADD, SUBTRACT, MULTIPLY, DIVIDE, OPENING_BRACKET, CLOSING_BRACKET, BLANK
    }

    public static int priorityOfOperator(Operator op) {
        switch (op) {
            case MULTIPLY:
                return 2;
            case DIVIDE:
                return 2;
            case ADD:
                return 1;
            case SUBTRACT:
                return 1;
            case OPENING_BRACKET:
                return 0;
            case CLOSING_BRACKET:
                return 0;
        }
        return 0;
    }

    public static Operator getOperator(char op) {
        switch (op) {
            case '+':
                return Operator.ADD;
            case '-':
                return Operator.SUBTRACT;
            case '*':
                return Operator.MULTIPLY;
            case '/':
                return Operator.DIVIDE;
            case '(':
                return Operator.OPENING_BRACKET;
            case ')':
                return Operator.CLOSING_BRACKET;
        }
        return Operator.BLANK;
    }

    public static int applyOp(int left, Operator op, int right) {
        if (op == Operator.ADD) {
            return left + right;
        } else if (op == Operator.SUBTRACT) {
            return left - right;
        } else if (op == Operator.MULTIPLY) {
            return left * right;
        } else if (op == Operator.DIVIDE) {
            return left / right;
        } else {
            return right;
        }
    }

    public static int calculate(String s) {
        Stack<Operator> operator = new Stack<>();
        Stack<Integer> operand = new Stack<>();

        for (int i = 0; i < s.length(); ) {
            char c = s.charAt(i);

            if(Character.isDigit(c)) {
                String num = "";
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num += s.charAt(i);
                    i++;
                }
                int current =(int) Long.parseLong(num);
                operand.push(current);
            } else if (getOperator(c) != Operator.BLANK) {
                Operator op = getOperator(c);
                if (op == Operator.CLOSING_BRACKET) {
                    while (!operator.isEmpty() && operator.peek() != Operator.OPENING_BRACKET) {
                        Operator currentOp = operator.pop();
                        int second = (int) operand.pop();//empty stack checks
                        int first = (int) operand.pop();
                        operand.push(applyOp(first, currentOp, second));
                    }
                    if(!operator.isEmpty()) {
                        operator.pop();//remove the opening bracket
                    }
                }else if ((op == Operator.OPENING_BRACKET) ||
                        operator.isEmpty() ||
                        (priorityOfOperator(op) > priorityOfOperator(operator.peek()))) {
                    operator.push(op);
                } else if (priorityOfOperator(op) <= priorityOfOperator(operator.peek())) {
                    while (!operator.isEmpty() && priorityOfOperator(op) <= priorityOfOperator(operator.peek())) {
                        Operator currentOp = operator.pop();
                        int second = (int) operand.pop();
                        int first = (int) operand.pop();
                        operand.push(applyOp(first, currentOp, second));
                    }
                    operator.push(op);
                }

                i++;
            }else if (getOperator(c) == Operator.BLANK) {
                i++;//ignore blank spaces
            }

        }//for loop ends

        while(!operator.isEmpty()){
            Operator op = operator.pop();
            int second = (int) operand.pop();//empty stack checks
            int first = (int) operand.pop();
            operand.push(applyOp(first, op, second));
        }
        return (int) operand.pop();

    }
}
