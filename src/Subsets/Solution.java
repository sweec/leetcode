package Subsets;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
    	ArrayList<ArrayList<Integer>> sets = new ArrayList<ArrayList<Integer>>();
    	if (S == null)
    		return sets;
    	Arrays.sort(S);
    	subsets(S, S.length, sets);
    	return sets;
    }
    
    private void subsets(int[] S, int len, ArrayList<ArrayList<Integer>> sets) {
    	if (len == 0) {
    		ArrayList<Integer> s = new ArrayList<Integer>();
    		sets.add(s);
    	} else {
    		subsets(S, len-1, sets);
    		int size = sets.size();
    		for (int i=0;i<size;i++) {
    			ArrayList<Integer> s = new ArrayList<Integer>(sets.get(i));
    			s.add(S[len-1]);
    			sets.add(s);
    		}
    	}
    }
}
