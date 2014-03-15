package WordBreak;

import java.util.Arrays;
import java.util.Set;

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null && dict == null)
        	return true;
        if (s == null || dict == null)
        	return false;
        if (dict.isEmpty())
        	return false;
        if (s.isEmpty()) {
        	if (dict.contains(""))
        		return true;
        	return false;
        }
        if (dict.contains(s))
        	return true;
        int len = s.length();
        boolean[][] breakable = new boolean[len][len+1];
        for (int i=0;i<len;i++)
        	Arrays.fill(breakable[i], false);
        boolean possible = false;
        for (int j=1;j<len;j++) {
        	if (dict.contains(s.substring(0, j))) {
        		breakable[0][j] = true;
        		possible = true;
        	}
        }
        if (!possible)
        	return false;
        possible = false;
        for (int i=1;i<len;i++) {
        	if (dict.contains(s.substring(i, len))) {
        		breakable[i][len] = true;
        		possible = true;
        	}
        }
        if (!possible)
        	return false;
        for (int j=2;j<=len;j++) {
        	for (int i=j-1;i>=0;i--) {
        		if ((i == 0 && breakable[0][j])
        				|| (j == len && breakable[i][j]))
        			continue;
        		if (i > 0 && j < len && dict.contains(s.substring(i, j))) {
        			breakable[i][j] = true;
        			continue;
        		}
        		for (int k=i+1;k<j;k++) {
        			if (breakable[i][k] && breakable[k][j]) {
        				breakable[i][j] = true;
        				break;
        			}
        		}
        	}
        }
        return breakable[0][len];
    }
}
