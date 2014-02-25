package Combinations;

import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
    	ArrayList<ArrayList<Integer>> combs = new ArrayList<ArrayList<Integer>>();
    	if (n < 1 || n < k || k < 1)
    		return combs;
    	combine(n, k, combs);
    	return combs;
    }
    
    private void combine(int n, int k, ArrayList<ArrayList<Integer>> combs) {
    	if (k == 1) {
    		for (int i=1;i<=n;i++) {
    			ArrayList<Integer> comb = new ArrayList<Integer>();
    			comb.add(i);
    			combs.add(comb);
    		}
    	} else {
    		if (k < n)
    			combine(n-1, k, combs);
    		int size = combs.size();
    		combine(n-1, k-1, combs);
    		for (int i=size;i<combs.size();i++) {
    			ArrayList<Integer> comb = combs.get(i);
    			comb.add(n);
    		}
    	}
    }
}
