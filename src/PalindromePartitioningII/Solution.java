package PalindromePartitioningII;

public class Solution {
    public int minCut(String s) {
        if (s == null || s.isEmpty())
        	return 0;
        int len = s.length();
        int[] min = new int[len];
        return minCut(s, len, min)-1;
    }
    
    /*
     * calculate mincut+1 for s[0:end) and save it in min[end-1]
     * min[end-1] == 0 means not calculated yet
     */
    private int minCut(String s, int end, int[] min) {
    	if (isPalindrome(s, 0, end)) {
    		min[end-1] = 1;
    		return 1;
    	}
    	int m = end;
    	for (int offset=1;offset<end;offset++) {
    		if (isPalindrome(s, offset, end)) {
    			int n = 1;
    			if (min[offset-1] == 0)
    				min[offset-1] = minCut(s, offset, min);
    			n += min[offset-1];
    			if (m > n) {
    				m = n;
    				if (m == 2)
    					break;
    			}
    		}
    	}
    	min[end-1] = m;
    	return m;
    }
    
    private boolean isPalindrome(String s, int beg, int end) {
    	end--;
    	while (end > beg) {
    		if (s.charAt(beg) != s.charAt(end))
    			return false;
    		beg++;
    		end--;
    	}
    	return true;
    }
}
