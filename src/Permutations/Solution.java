package Permutations;

import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
    	ArrayList<ArrayList<Integer>> ps = new ArrayList<ArrayList<Integer>>();
    	if (num == null || num.length < 1)
    		return ps;
    	ArrayList<Integer> p1 = new ArrayList<Integer>();
    	p1.add(num[0]);
    	ps.add(p1);
    	for (int i=1;i<num.length;i++) {
    		int size = ps.size();
    		for (int k=0;k<size;k++) {
    			ArrayList<Integer> p = ps.get(k);
    			for (int j=p.size()-1;j>=0;j--) {
    				ArrayList<Integer> pi = new ArrayList<Integer>(p);
    				pi.add(j, num[i]);
    				ps.add(pi);
    			}
    			p.add(num[i]);
    		}
    	}
    	return ps;
    }
}
