package InterleavingString;

import java.util.Arrays;

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null)
        	return false;
    	int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if (len1+len2 != len3)
        	return false;
        if (len1 == 0 && len2 == 0 && len3 == 0)
        	return true;
    	if (len1 == 0)
    		return s2.equals(s3);
    	if (len2 == 0)
    		return s1.equals(s3);
    	boolean[][] isILs = new boolean[len1+1][len2+1];
    	for (int i=0;i<=len1;i++)
    		Arrays.fill(isILs[i], false);
    	isILs[0][0] = true;
    	for (int i=1;i<=len1;i++) {
    		isILs[i][0] = isILs[i-1][0] && (s1.charAt(i-1) == s3.charAt(i-1));
    		if (!isILs[i][0])
    			break;
    	}
    	for (int j=1;j<=len2;j++) {
    		isILs[0][j] = isILs[0][j-1] && (s2.charAt(j-1) == s3.charAt(j-1));
    		if (!isILs[0][j])
    			break;
    	}
    	for (int i=1;i<=len1;i++) {
    		char c1 = s1.charAt(i-1);
    		for (int j=1;j<=len2;j++) {
    			int k = i+j-1;
    			char c2 = s2.charAt(j-1), c3 = s3.charAt(k);
    			if ((c1 == c3 && isILs[i-1][j])
    					|| (c2 == c3 && isILs[i][j-1]))
    				isILs[i][j] = true;
    		}
    	}
        return isILs[len1][len2];
    }
}
