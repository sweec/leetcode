package SubstringWithConcatenationOfAllWords;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (S == null || L == null || L.length < 1)
        	return list;
        int n = L.length, m = L[0].length(), len = S.length();
        if (m == 0 && len == 0) {
        	list.add(0);
        	return list;
        }
        int mn = n*m;
        if (m == 0 || len == 0 || len < mn)
        	return list;
        HashMap<String, Integer> lmap = new HashMap<String, Integer>();
        HashMap<Integer, Integer> fmap = new HashMap<Integer, Integer>();
        for (int i=0;i<n;i++) {
        	if (lmap.containsKey(L[i])) {
        		Integer l = lmap.get(L[i]);
        		fmap.put(l, fmap.get(l)+1);
        	} else {
        		lmap.put(L[i], i+1);
        		fmap.put(i+1, 1);
        	}
        }
        int[] label = new int[len-m+1];
        for (int i=0;i<=len-m;i++) {
        	String s = S.substring(i,i+m);
        	if (lmap.containsKey(s))
        		label[i] = lmap.get(s);
        }
        for (int i=0;i<m;i++) {
        	HashMap<Integer, ArrayList<Integer>> lset = new HashMap<Integer, ArrayList<Integer>>();
        	HashMap<Integer, Integer> fset = new HashMap<Integer, Integer>();
        	int index = i, beg = -1, count = 0;
        	do {
        		if (label[index] == 0) {
        			while ((len-index-m) >= mn) {
        				index += m;
        				if (label[index] > 0)
        					break;
        			}
        			if (label[index] == 0)
        				break;
        			lset.clear();
        			fset.clear();
        			count = 0;
        		}
        		int l = label[index];
        		ArrayList<Integer> locs = lset.get(l);
        		int freq = 0;
        		if (fset.containsKey(l))
        			freq = fset.get(l);
        		freq++;
        		int tfreq = fmap.get(l);
        		if (freq > tfreq) {
        			int offset = locs.get(0);
        			locs.remove(0);
        			locs.add(index);
        			for (int j=beg;j<offset;j+=m) {
        				lset.get(label[j]).remove(0);
        				int f = fset.get(label[j]);
        				if (f == fmap.get(label[j]))
        					count--;
        				f--;
        				if (f == 0)
        					fset.remove(label[j]);
        				else
        					fset.put(label[j], f);
        			}
        			beg = offset + m;
        		} else {
         			if (locs == null)
        				locs = new ArrayList<Integer>();
        			locs.add(index);
        			lset.put(l, locs);
        			if (fset.isEmpty())
        				beg = index;
        			fset.put(l, freq);
        			if (freq == tfreq) {
        				count++;
        				if (count == fmap.size()) {
        					list.add(beg);
        					lset.get(label[beg]).remove(0);
        					int f = fset.get(label[beg])-1;
        					if (f == 0)
        						fset.remove(label[beg]);
        					else
        						fset.put(label[beg], f);
        					count--;
        					beg += m;
        				}
        			}
        		}
        		index += m;
        		if (fset.isEmpty()) {
        			if ((len-index) < mn)
        				break;
        		} else if ((len-beg) < mn)
        			break;
        	} while (true);
        }
        return list;
    }
}
