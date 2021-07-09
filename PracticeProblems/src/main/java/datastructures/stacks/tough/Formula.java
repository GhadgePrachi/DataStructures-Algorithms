package datastructures.stacks.tough;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class Formula {
    /**Decode String**/
    public String decodeString(String s) {
        Stack<String> chars = new Stack<>();
        Stack<String> counts = new Stack<>();
        for (int i = 0; i < s.length();) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int startIndex = i;
                while (Character.isDigit(s.charAt(i))) {
                    i++;
                }
                String num = s.substring(startIndex, i);
                counts.push(num);
            }else if (ch == '[' || Character.isLetter(ch)) {
                chars.push(String.valueOf(ch));
                i++;
            }else if (ch == ']') {
                //Compute Element
                StringBuilder element = new StringBuilder();
                while(!chars.isEmpty() && !chars.peek().equals("[")) {
                    element.insert(0, chars.pop());
                }

                if(!chars.isEmpty()){
                    chars.pop();//Remove  '['
                }

                //Compute Count
                int count = 1;
                if(!counts.isEmpty()){
                    count = Integer.parseInt(counts.pop());
                }

                //Apply Element - Count times
                StringBuilder subpart = new StringBuilder();
                while (count > 0) {
                    subpart.append(element.toString());
                    count--;
                }
                chars.push(subpart.toString());
                i++;
            }
        }
        return buildString(chars);
    }

    private String buildString(Stack<String> chars) {
        StringBuilder sb = new StringBuilder();
        while (!chars.isEmpty()) {
            sb.insert(0, chars.pop());
        }
        return sb.toString();
    }

    /**Decode Chemical Formula**/
    public String countOfAtoms(String formula) {
        int i = 0, N = formula.length();
        Stack<Map<String, Integer>> stack = new Stack();
        stack.push(new TreeMap());
        while (i < N) {
            if (formula.charAt(i) == '(') {
                stack.push(new TreeMap());
                i++;
            } else if (formula.charAt(i) == ')') {
                Map<String, Integer> top = stack.pop();
                i++;
                //Get the Multiplicity Factor
                int startIndex = i, multiplicity = 1;
                while (i < N && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                if (i > startIndex) {
                    multiplicity = Integer.parseInt(formula.substring(startIndex, i));
                }

                //Apply the Multiplicity Factor
                for (String c : top.keySet()) {
                    int v = top.get(c);
                    stack.peek().put(c, stack.peek().getOrDefault(c, 0) + (v * multiplicity));
                }
            } else {
                i++;
                //Compute Element Name
                int startIndex = i;
                while (i < N && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String name = formula.substring(startIndex, i);

                //Compute Element Count
                startIndex = i;
                int multiplicity = 1;;
                while (i < N && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                if (i > startIndex) {
                    Integer.parseInt(formula.substring(startIndex, i));
                }

                //Add Element Count to existing count
                stack.peek().put(name, stack.peek().getOrDefault(name, 0) + multiplicity);
            }
        }

        StringBuilder atom = buildAtom(stack.peek());
        return atom.toString();
    }

    private StringBuilder buildAtom(Map<String, Integer> map) {
        StringBuilder atom = new StringBuilder();
        for (String name : map.keySet()) {
            int multiplicity = map.get(name);
            atom.append(name);
            if (multiplicity > 1) {
                atom.append(String.valueOf(multiplicity));
            }
        }
        return atom;
    }
}
