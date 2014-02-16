package LongestPalindromicSubstring;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2)
        	return s;
        // records occurrences of all chars
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        int len = s.length();
        for (int i=0;i<len;i++) {
        	char c = s.charAt(i);
        	ArrayList<Integer> list = null;
        	if (!map.containsKey((int) c))
        		list = new ArrayList<Integer>();
        	else
        		list = map.get((int) c);
    		list.add(i);
    		map.put((int) c, list);
        }
        // records occurrences of chars only appeared once
        int[] badCounts = new int[len+1];
        badCounts[0] = 0;
        int num = 0;
        for (int i=0;i<len;i++) {
        	if (map.get((int) s.charAt(i)).size() == 1)
        		num++;
        	badCounts[i+1] = num;
        }
        // 
        // now search for parlindromic substring
        int maxSize = 1, beg = 0;
        int offset = 0;
        while (len-offset > maxSize) {
        	char c = s.charAt(offset);
        	// check if there is a parlindrome start with c
        	ArrayList<Integer> list = map.get((int) c);
        	// ignore size 1 parlindrome
        	if (list.size() == 1) {
        		offset++;
        		continue;
        	}
        	// iterate the possible parlindrome tails
        	for (int i=list.size()-1;i>0;i--) {
        		int tail = list.get(i);
        		if (tail <= offset)
        			break;
        		int size = tail-offset+1;
        		if (size <= maxSize)
        			break;
        		int badCount = badCounts[tail+1]-badCounts[offset];
        		// not a parlindrome if contains > 2 single chars
        		if (badCount > 1)
        			continue;
        		// not a parlindrome if the single char not located at the center
        		if (badCount == 1
        				&& ((tail-offset) % 2 != 0
        				|| map.get((int)s.charAt((offset+tail)/2)).size() != 1))
        			continue;
        		if (isPalindrome(s, offset+1, tail-1)) {
        			maxSize = size;
        			beg = offset;
        			break;
        		}
        	}
        	offset++;
        }
        return s.substring(beg, beg+maxSize);
    }
    
    private boolean isPalindrome(String s, int beg, int end) {
    	while (end > beg) {
    		if (s.charAt(beg) != s.charAt(end))
    			return false;
    		beg++;
    		end--;
    	}
    	return true;
    }
}
