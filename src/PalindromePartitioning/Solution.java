package PalindromePartitioning;

import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
    	ArrayList<ArrayList<String>> ps = new ArrayList<ArrayList<String>>();
    	if (s == null || s.isEmpty()) {
    		ArrayList<String> p = new ArrayList<String>();
    		p.add("");
    		ps.add(p);
    		return ps;
    	}
    	partition(s, s.length(), ps);
    	return ps;
    }
    
    private void partition(String s, int len, ArrayList<ArrayList<String>> ps) {
    	if (isPalindrome(s, 0, len)) {
    		ArrayList<String> p = new ArrayList<String>();
    		p.add(s.substring(0, len));
    		ps.add(p);
    	}
    	for (int i=1;i<len;i++) {
    		if (isPalindrome(s, i, len)) {
    			int size = ps.size();
    			partition(s, i, ps);
    			for (int j=size;j<ps.size();j++) {
    				ArrayList<String> p = ps.get(j);
    				p.add(s.substring(i, len));
    			}
    		}
    	}
    }
    
    private boolean isPalindrome(String s, int beg, int len) {
    	int end = len -1;
    	while (end > beg) {
    		if (s.charAt(beg) != s.charAt(end))
    			return false;
    		beg++;
    		end--;
    	}
    	return true;
    }
}
