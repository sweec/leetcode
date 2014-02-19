package Anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
    	ArrayList<String> rets = new ArrayList<String>();
    	if (strs == null || strs.length < 2)
    		return rets;
    	int len = strs.length;
    	HashMap<Integer, ArrayList<Count>> map = new HashMap<Integer, ArrayList<Count>>();
    	for (int i=0;i<len;i++) {
    		if (strs[i] == null)
    			continue;
    		Count count = new Count(i);
    		int l = 0;
    		for (int j=0;j<strs[i].length();j++) {
    			char c = strs[i].charAt(j);
    			if (c >= 'a' && c <= 'z') {
    				count.charFreq[c-'a']++;
    				l++;
    			} else if (c >= 'A' && c <= 'Z') {
    				count.charFreq[c-'A']++;
    				l++;
    			}
    		}
    		ArrayList<Count> list = null;
    		if (map.containsKey(l))
    			list = map.get(l);
    		else
    			list = new ArrayList<Count>();
    		list.add(count);
    		map.put(l, list);
    	}
    	for (ArrayList<Count> list:map.values()) {
    		if (list.size() < 2)
    			continue;
        	HashSet<Integer> set = new HashSet<Integer>();
    		int size = list.size();
    		for (int i=0;i<size-1;i++) {
    			if (set.contains(i))
    				continue;
    			Count count1 = list.get(i);
    			for (int j=i+1;j<size;j++) {
    				if (set.contains(j))
    					continue;
    				Count count2 = list.get(j);
    				int k = 0;
    				for (;k<26;k++)
    					if (count1.charFreq[k] != count2.charFreq[k])
    						break;
    				if (k == 26) {
    					if (!set.contains(i)) {
    						rets.add(strs[count1.index]);
    						set.add(i);
    					}
    					rets.add(strs[count2.index]);
    					set.add(j);
    				}
    			}
    		}
    	}
    	return rets;
    }
    
    private class Count {
    	public int index;
    	public int[] charFreq;
    	
    	public Count(int i) {
    		index = i;
    		charFreq = new int[26];
    	}
    }
}
