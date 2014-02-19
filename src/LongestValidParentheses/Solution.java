package LongestValidParentheses;

import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public int longestValidParentheses(String s) {
    	if (s == null || s.isEmpty())
    		return 0;
    	Stack<Integer> Q = new Stack<Integer>();
    	// map contains count for paired parentheses so far for each location
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	// curPaired: total length of paired parentheses at all locations
    	// curPaired is used to detect early ending condition
    	int max = 0, curPaired = 0;
    	int len = s.length();
    	for (int i=0;i<len;i++) {
    		char c = s.charAt(i);
    		if (c == '(' || c == '[' || c == '{') {
    			Q.push((int) c);
    			if ((len-1-i)*2+curPaired <= max)
    				return max;
    		} else {
    			boolean reset = false;
    			if (c == ')' && (Q.isEmpty() || Q.pop() != '('))
    				reset = true;
    			if (c == ']' && (Q.isEmpty() || Q.pop() != '['))
    				reset = true;
    			if (c == '}' && (Q.isEmpty() || Q.pop() != '{'))
    				reset = true;
    			if (!reset) {
    				curPaired += 2;
    				int length = 2;
    				int size = Q.size();
    				Integer next = map.get(size+1);
    				if (next != null) {
    					length += next;
    					map.remove(size+1);
    				}
    				Integer cur = map.get(size);
    				if (cur != null)
    					length += cur;
    				map.put(size, length);
    			} else {
    				for (int length:map.values())
    					if (length > max)
    						max = length;
    				if (len-1-i <= max)
    					break;
    				map.clear();
    				curPaired = 0;
    				Q.clear();
    			}
    		}
    	}
		for (int length:map.values())
			if (length > max)
				max = length;
        return max;
    }
}
