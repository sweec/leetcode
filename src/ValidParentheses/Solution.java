package ValidParentheses;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.isEmpty())
        	return true;
        Stack<Integer> Q = new Stack<Integer>();
        int len = s.length();
        for (int i=0;i<len;i++) {
        	char c = s.charAt(i);
        	if (c == '(' || c == '[' || c == '{') {
        		Q.push((int) c);
        		// too many left parentheses
        		if (Q.size() > len/2)
        			return false;
        	} else if (c == ')') {
        		if (Q.isEmpty() || Q.pop() != '(')
        			return false;
        	} else if (c == ']') {
        		if (Q.isEmpty() || Q.pop() != '[')
        			return false;
        	} else if (c == '}') {
        		if (Q.isEmpty() || Q.pop() != '{')
        			return false;
        	}
        }
        if (Q.isEmpty())
        	return true;
        return false;
    }
}
