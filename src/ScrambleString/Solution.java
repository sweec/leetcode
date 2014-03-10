package ScrambleString;

import java.util.HashMap;

public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null && s2 == null)
        	return true;
        if (s1 == null || s2 == null)
        	return false;
        int len1 = s1.length(), len2 = s2.length();
        if (len1 != len2)
        	return false;
        if (len1 == 0)
        	return true;
        return isScramble(s1, 0, s2, 0, len1);
    }
    
    private boolean isScramble(String s1, int beg1, String s2, int beg2, int len) {
    	if (len == 1) {
    		if (s1.charAt(beg1) == s2.charAt(beg2))
    			return true;
    		else
    			return false;
    	} else {
    		HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
    		HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
    		for (int i=1;i<len;i++) {
    			int c1 = s1.charAt(beg1+i-1), c2 = s2.charAt(beg2+i-1), c3 = s2.charAt(beg2+len-i);
    			if (map1.containsKey(c1))
    				map1.put(c1, map1.get(c1)+1);
    			else
    				map1.put(c1, 1);
    			if (map1.containsKey(c2))
    				map1.put(c2, map1.get(c2)-1);
    			else
    				map1.put(c2, -1);
    			if (map2.containsKey(c1))
    				map2.put(c1, map2.get(c1)+1);
    			else
    				map2.put(c1, 1);
    			if (map2.containsKey(c3))
    				map2.put(c3, map2.get(c3)-1);
    			else
    				map2.put(c3, -1);
    			if (isEmpty(map1) && isScramble(s1, beg1, s2, beg2, i)
    					&& isScramble(s1, beg1+i, s2, beg2+i, len-i))
    				return true;
    			if (isEmpty(map2) && isScramble(s1, beg1, s2, beg2+len-i, i)
    					&& isScramble(s1, beg1+i, s2, beg2, len-i))
    				return true;
    		}
    		return false;
    	}
    }
    
    private boolean isEmpty(HashMap<Integer, Integer> map) {
    	for (int v:map.values()) {
    		if (v != 0)
    			return false;
    	}
    	return true;
    }
}
