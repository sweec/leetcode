package WordBreakII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
    	ArrayList<String> sentences = new ArrayList<String>();
        if (s == null || dict == null || dict.isEmpty())
        	return sentences;
        if (s.isEmpty()) {
        	if (dict.contains(""))
        		sentences.add("");
        	return sentences;
        }
        if (dict.contains(s))
        	sentences.add(s);
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
        	return sentences;
        possible = false;
        for (int i=1;i<len;i++) {
        	if (dict.contains(s.substring(i, len))) {
        		breakable[i][len] = true;
        		possible = true;
        	}
        }
        if (!possible)
        	return sentences;
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
        if (breakable[0][len])
        	sentences = getSentences(s, dict, new HashMap<Integer, ArrayList<String>>(), breakable, len);
        return sentences;
    }
    
    private ArrayList<String> getSentences(String s, Set<String> dict,
    		HashMap<Integer, ArrayList<String>> map, boolean[][] breakable, int len) {
		ArrayList<String> sbs = new ArrayList<String>();
		String word = s.substring(0, len);
		if (dict.contains(word))
			sbs.add(word);
    	for (int i=1;i<len;i++) {
    		if (!breakable[0][i] || !breakable[i][len])
    			continue;
    		word = s.substring(i, len);
    		if (!dict.contains(word))
    			continue;
    		ArrayList<String> sbs0 = map.get(i);
    		if (sbs0 == null)
    			sbs0 = getSentences(s, dict, map, breakable, i);
    		for (String sb:sbs0)
    			sbs.add(sb+" "+word);
    		map.put(len, sbs);
    	}
		return sbs;
    }
}
