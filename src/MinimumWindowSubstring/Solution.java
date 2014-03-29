package MinimumWindowSubstring;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public String minWindow(String S, String T) {
        if (S == null || T == null)
        	return "";
        if (S.isEmpty() || T.isEmpty())
        	return "";
        int len1 = S.length(), len2 = T.length();
        if (len1 < len2)
        	return "";
        HashMap<Integer, Integer> tmap = new HashMap<Integer, Integer>();
        HashMap<Integer, ArrayList<Integer>> smap = new HashMap<Integer, ArrayList<Integer>>();
        for (int i=0;i<len2;i++) {
        	char c = T.charAt(i);
        	if (tmap.containsKey((int)c))
        		tmap.put((int)c, tmap.get((int)c)+1);
        	else {
        		tmap.put((int)c, 1);
        		smap.put((int)c, new ArrayList<Integer>());
        	}
        }
        int minbeg=0, minlen=Integer.MAX_VALUE, len = len2;
        for (int i=0;i<len1;i++) {
        	if ((len1-i)<len)
        		break;
        	char c = S.charAt(i);
        	if (!tmap.containsKey((int)c))
        		continue;
        	ArrayList<Integer> list = smap.get((int)c);
    		list.add(i); len--;
        	int tcount = tmap.get((int)c), scount = list.size();
        	if (scount < tcount)
        		continue;
        	if (scount > tcount) {
        		list.remove(0);
        		len++;
        	}
        	if (len == 0) {
        		int beg = list.get(0);
        		if (i-beg+1 < minlen) {
        			list = null;
        			for (ArrayList<Integer> l:smap.values()) {
        				int lbeg = l.get(0);
        				if (i-lbeg+1 >= minlen) {
        					list = l;
        					break;
        				}
        				beg = Math.min(beg, lbeg);
        			}
        		}
        		if (list == null) {
        			minbeg = beg;
        			minlen = i-minbeg+1;
        			if (minlen == len2)
        				break;
        		} else {
        			do {
        				list.remove(0);
        				len++;
        			} while (!list.isEmpty() && (i-list.get(0)+1>=minlen));
        		}
        	}
        }
        if (minlen <= len1)
        	return S.substring(minbeg, minbeg+minlen);
        else
        	return "";
    }
}
