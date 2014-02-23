package PascalTriangle;

import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
    	ArrayList<ArrayList<Integer>> tas = new ArrayList<ArrayList<Integer>>();
    	if (numRows < 1)
    		return tas;
    	ArrayList<Integer> pre = new ArrayList<Integer>();
    	pre.add(1);
    	tas.add(pre);
    	if (numRows == 1)
    		return tas;
    	for (int i=2;i<=numRows;i++) {
    		ArrayList<Integer> cur = new ArrayList<Integer>();
    		cur.add(1);
    		for (int j=1;j<i-1;j++)
    			cur.add(pre.get(j-1)+pre.get(j));
    		cur.add(1);
    		tas.add(cur);
    		pre = cur;
    	}
    	return tas;
    }
}
