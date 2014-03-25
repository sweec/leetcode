package WordLadder;

import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
    	if (start == null || end == null || dict == null)
    		return 0;
        if (start.equals(end))
        	return 1;
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int llen = 2, len = start.length();
        ArrayList<String> cur = new ArrayList<String>();
        dict.add(end); cur.add(start); dict.remove(start);
        while (!cur.isEmpty() && !dict.isEmpty()) {
        	for (String s:cur)
        		if (isadj(s, end))
        			return llen;
        	ArrayList<String> next = new ArrayList<String>();
        	for (String s:cur) {
            	StringBuffer sb = new StringBuffer(s);
            	for (int i=0;i<len;i++) {
            		char c0 = s.charAt(i);
            		for (char c:chars) {
            			if (c != c0) {
            				sb.setCharAt(i, c);
            				String s2 = sb.toString();
            				if (dict.contains(s2)) {
            					next.add(s2);
            					dict.remove(s2);
            				}
            			}
            		}
            		sb.setCharAt(i, c0);
            	}
        	}
        	cur = next;
        	llen++;
        }
        return 0;
    }
    
    private boolean isadj(String s1, String s2) {
    	int len = s1.length();
    	for (int i=0;i<len;i++) {
    		if (s1.charAt(i) != s2.charAt(i)) {
    			if (i == len-1 || s1.substring(i+1).equals(s2.substring(i+1)))
    				return true;
    			else
    				return false;
    		}
    	}
    	return false;
    }
}
