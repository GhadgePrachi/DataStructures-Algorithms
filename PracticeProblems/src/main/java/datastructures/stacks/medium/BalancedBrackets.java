package datastructures.stacks.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class BalancedBrackets {
    public static boolean balancedBrackets(String str) {
        HashSet<Character> openingBracketsSet = populateHashSet();
        HashMap<Character, Character> brackets = populateHashMap();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if (openingBracketsSet.contains(current)) {//opening bracket
                stack.push(current);
            } else if (brackets.containsKey(current)) {//closing bracket
                if (stack.isEmpty() || !isMatch(stack.pop(), current, brackets)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static HashSet<Character> populateHashSet() {
        HashSet<Character> openingBracketsSet = new HashSet<>();
        openingBracketsSet.add('(');
        openingBracketsSet.add('{');
        openingBracketsSet.add('[');
        return openingBracketsSet;
    }

    public static HashMap<Character, Character> populateHashMap() {
        HashMap<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');
        return brackets;
    }

    public static boolean isMatch(char openingBracket, char closingBracket, HashMap<Character, Character> brackets) {
        if (brackets.containsKey(closingBracket)) {
            char value = brackets.get(closingBracket);
            if (value == openingBracket) {
                return true;
            }
        }
        return false;
    }
}
