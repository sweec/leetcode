package RegularExpressionMatching;

public class Solution {
    public boolean isMatch(String s, String p) {
        if (p == null) {
        	if (s == null)
        		return true;
        	else
        		return false;
        }
        if (s == null)
        	return false;
        if (p.isEmpty()) {
        	if (s.isEmpty())
        		return true;
        	else
        		return false;
        }
        return isMatch(s, 0, p, 0);
    }
    
    private boolean isMatch(String s, int beg1, String p, int beg2) {
       	char cur = p.charAt(beg2);
		if (cur == '*')	// wrong regular expression
			return false;
    	int index = beg2+1;
     	if (index < p.length()) {
    		char next = p.charAt(index);
    		if (next != '*') {
    			if (cur == '.') {
    				if (beg1 < s.length())
    					return isMatch(s, beg1+1, p, index);
    				else
    					return false;
    			} else {
    				if (beg1 < s.length() && s.charAt(beg1) == cur)
    					return isMatch(s, beg1+1, p, index);
    				else
    					return false;
    			}
    		} else {
    			index++;
    			if (index < p.length()) {
    				if (cur == '.') {
    					for (int i=beg1;i<=s.length();i++)
    						if (isMatch(s, i, p, index))
    							return true;
    					return false;
    				} else {
    					for (int i=beg1;i<=s.length();i++) {
    						if (isMatch(s, i, p, index))
    							return true;
    						if (i < s.length() && s.charAt(i) != cur)
    							break;
    					}
    					return false;
    				}
    			} else {
    				if (cur == '.')
    					return true;
    				else {
    					for (int i=beg1;i<s.length();i++) {
    						if (s.charAt(i) != cur)
    							return false;
    					}
    					return true;
    				}
    			}
    		}
    	} else {
    		if (cur == '.') {
    			if (beg1 == s.length()-1)
    				return true;
    			else
    				return false;
    		} else {
    			if (beg1 == s.length()-1 && s.charAt(beg1) == cur)
    				return true;
    			else
    				return false;
    		}
    	}
    }
}
