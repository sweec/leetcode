package WildcardMatching;

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
    	int len1 = s.length(), len2 = p.length();
    	do {
        	if (beg2 >= len2) {
        		if (beg1 >= len1)
        			return true;
        		return false;
        	}
    		char cur = p.charAt(beg2);
    		int index = beg2+1;
    		while (cur == '*' && index < len2) {
    			cur = p.charAt(index);
    			index++;
    		}
    		// p only contains * after beg2 ?
    		if (cur == '*')
    			return true;
    		// p contains * at beg2 but contains other symbols after
    		if (index > beg2+1) {
    			// get the pattern before next * or until end of p
    			beg2 = index - 1;
    			while (cur != '*' && index < len2) {
    				cur = p.charAt(index);
    				index++;
    			}
    			if (cur == '*')
    				index--;
    			int size = index - beg2;
    			// find 1st match in s to the pattern with * followed in p
    			if (cur == '*') {
    				for (;beg1<=len1-size;beg1++)
    					if (isMatch(s, beg1, p, beg2, index))
    						break;
    				if (beg1 > len1-size)
    					return false;
        			beg1 += size;
        			beg2 = index;
    			// or match last part of s to the pattern with no * followed in p
    			} else {
    				if (len1-beg1 < size)
    					return false;
    				if (isMatch(s, len1-size, p, beg2, index))
    					return true;
    				return false;
    			}
    		// It's not * at beg2 of p
    		} else {
    			if (beg1 >= len1)
    				return false;
    			if (cur != '?' && s.charAt(beg1) != cur)
    				return false;
    			beg1++;
    			beg2++;
    		}
    	} while (true);
    }
    
    private boolean isMatch(String s, int beg1, String p, int beg2, int end2) {
    	for (int i=0;i<end2-beg2;i++) {
    		char c = p.charAt(beg2+i);
    		if (c != '?' && s.charAt(beg1+i) != c)
    			return false;
    	}
    	return true;
    }
}
