package datastructures.stacks.tough;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class Formula {
    public String decodeString(String s) {
        Stack<String> chars = new Stack<>();
        Stack<String> count = new Stack<>();
        for (int i = 0; i < s.length();) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                String num = "";
                while (Character.isDigit(s.charAt(i))) {
                    num = num + s.charAt(i);
                    i++;
                }
                count.push(num);
            }else if (ch == '[' || Character.isLetter(ch)) {
                ch = s.charAt(i);
                chars.push(String.valueOf(ch));
                i++;
            }else if (ch == ']') {
                /*Building the string between opening and closing bracket*/
                StringBuilder strb = new StringBuilder();
                while(!chars.isEmpty() && !chars.peek().equals("[")){
                    String ch1 = chars.pop();
                    strb.insert(0, ch1);
                }

                /*Remove  '[' */
                if(!chars.isEmpty()){
                    chars.pop();
                }

                /*Repeating string k times*/
                String str = strb.toString();
                if(!count.isEmpty()){
                    int k = Integer.parseInt(count.pop());
                    while (k > 1) {// append that string appropriate times.
                        strb.append(str);
                        k--;
                    }
                }

                /*Push the processed string to chars stack*/
                chars.push(strb.toString());
                i++;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!chars.isEmpty()) {
            sb.insert(0, chars.pop());
        }
        return sb.isEmpty() ? "" : sb.toString();
    }

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
                int iStart = ++i, multiplicity = 1;
                while (i < N && Character.isDigit(formula.charAt(i))) i++;
                if (i > iStart) multiplicity = Integer.parseInt(formula.substring(iStart, i));
                for (String c : top.keySet()) {
                    int v = top.get(c);
                    stack.peek().put(c, stack.peek().getOrDefault(c, 0) + v * multiplicity);
                }
            } else {
                int iStart = i++;
                while (i < N && Character.isLowerCase(formula.charAt(i))) i++;
                String name = formula.substring(iStart, i);
                iStart = i;
                while (i < N && Character.isDigit(formula.charAt(i))) i++;
                int multiplicity = i > iStart ? Integer.parseInt(formula.substring(iStart, i)) : 1;
                stack.peek().put(name, stack.peek().getOrDefault(name, 0) + multiplicity);
            }
        }

        StringBuilder ans = new StringBuilder();
        for (String name : stack.peek().keySet()) {
            ans.append(name);
            int multiplicity = stack.peek().get(name);
            if (multiplicity > 1) ans.append("" + multiplicity);
        }
        return new String(ans);
    }
}
