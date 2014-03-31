package WordLadderII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
    	ArrayList<ArrayList<String>> ladders = new ArrayList<ArrayList<String>>();
    	if (start == null || end == null || dict == null)
    		return ladders;
        if (start.equals(end)) {
        	ArrayList<String> ladder = new ArrayList<String>();
        	ladder.add(start); ladders.add(ladder);
        	return ladders;
        }
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int llen = 2, len = start.length();
        ArrayList<ArrayList<String>> lists = new ArrayList<ArrayList<String>>();
        ArrayList<String> cur = new ArrayList<String>();
        dict.add(end); cur.add(start); dict.remove(start);
        boolean found = false;
        while (!cur.isEmpty() && !dict.isEmpty()) {
        	for (String s:cur)
        		if (isadj(s, end)) {
        			found = true;
        			break;
        		}
        	if (found)
        		break;
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
        	lists.add(cur);
        	llen++;
        }
        if (!found)
        	return ladders;
        if (lists.isEmpty()) {
        	ArrayList<String> ladder = new ArrayList<String>();
        	ladder.add(start); ladder.add(end); ladders.add(ladder);
        	return ladders;
        }
        HashMap<String, ArrayList<ArrayList<String>>> map = new HashMap<String, ArrayList<ArrayList<String>>>();
        return findLadders(start, end, llen-3, lists, map);
    }
    
    private ArrayList<ArrayList<String>> findLadders(String start, String end, int index,
    		ArrayList<ArrayList<String>> lists, HashMap<String, ArrayList<ArrayList<String>>> map) {
    	ArrayList<ArrayList<String>> ladders = new ArrayList<ArrayList<String>>();
    	if (index == 0) {
    		for (String s:lists.get(0)) {
    			if (isadj(s, end)) {
    	        	ArrayList<String> ladder = new ArrayList<String>();
    				ladder.add(start); ladder.add(s); ladder.add(end);
    				ladders.add(ladder);
    			}
    		}
    		return ladders;
    	}
    	for (String s:lists.get(index)) {
    		if (isadj(s, end)) {
    			ArrayList<ArrayList<String>> pre = map.get(s);
    			if (pre == null) {
    				pre = findLadders(start, s, index-1, lists, map);
    				map.put(s, pre);
    			}
    			for (ArrayList<String> preladder:pre) {
    				ArrayList<String> ladder = new ArrayList<String>(preladder);
    				ladder.add(end);
    				ladders.add(ladder);
    			}
    		}
    	}
    	return ladders;
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
