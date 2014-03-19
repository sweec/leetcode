package EvaluateReversePolishNotation;

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null)
        	return 0;
        if (tokens.length < 3)
        	return Integer.parseInt(tokens[0]);
        Stack<Integer> stack = new Stack<Integer>();
        int len = tokens.length;
        int b = Integer.parseInt(tokens[0]);
        stack.push(b);
        int i = 1;
        while (i < len) {
        	b = Integer.parseInt(tokens[i++]);
        	do {
        		int o = operator(tokens[i]);
        		if (o == 0) {
        			stack.push(b);
        			break;
        		} else {
        			int a = stack.pop();
        			if (o == 1)
        				b = a + b;
        			else if (o == 2)
        				b = a - b;
        			else if (o == 3)
        				b = a * b;
        			else if (b == 0) {
        				if (a < 0)
        					return Integer.MIN_VALUE;
        				else
        					return Integer.MAX_VALUE;
        			} else
        				b = a / b;
        		}
        		i++;
        	} while (i < len);
        }
        return b;
    }
    
    private int operator(String o) {
    	if (o.equals("+")) return 1;
    	if (o.equals("-")) return 2;
    	if (o.equals("*")) return 3;
    	if (o.equals("/")) return 4;
    	return 0;
   }
}
