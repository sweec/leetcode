package DistinctSubsequences;

public class Solution {
    public int numDistinct(String S, String T) {
        if (S == null || T == null || S.length() < T.length())
        	return 0;
        if (T.isEmpty())
        	return 1;
        int lens = S.length(), lent = T.length();
        int[][] nums = new int[lens][lent];
        if (S.charAt(0) == T.charAt(0))
        	nums[0][0] = 1;
        for (int i=1;i<lens;i++) {
        	char cs = S.charAt(i);
        	for (int j=0;j<=Math.min(lent-1, i);j++) {
        		char ct = T.charAt(j);
        		nums[i][j] = nums[i-1][j];
        		if (cs == ct) {
        		    if (j > 0)
        			    nums[i][j] += nums[i-1][j-1];
        			else
        			    nums[i][j]++;
        		}
        	}
        }
        return nums[lens-1][lent-1];
    }
}
