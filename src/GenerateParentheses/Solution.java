package GenerateParentheses;

import java.util.ArrayList;

public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
    	ArrayList<String> parenthesis = new ArrayList<String>();
    	generateParenthesis(n, parenthesis);
    	return parenthesis;
    }
    
    private void generateParenthesis(int n, ArrayList<String> parenthesis) {
    	if (n < 1)
    		parenthesis.add("");
    	else {
    		generateParenthesis(n-1, parenthesis);
    		int size = parenthesis.size();
    		for (int i=0;i<size;i++) {
    			String cur = parenthesis.get(i);
    			for (int j=2*n-3;j>0;j--) {
    				if (cur.charAt(j) == '(')
    					break;
    				StringBuffer sb = new StringBuffer();
    				sb.append(cur.substring(0, j));
    				sb.append("(");
    				sb.append(cur.substring(j));
    				sb.append(")");
    				parenthesis.add(sb.toString());
    			}
    			parenthesis.set(i, cur+"()");
    		}
    	}
    }
}
