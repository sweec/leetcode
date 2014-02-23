package PascalTriangleII;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
    	ArrayList<Integer> ta = new ArrayList<Integer>();
    	if (rowIndex < 0)
    		return ta;
    	ta.add(1);
    	if (rowIndex == 0)
    		return ta;
    	for (int i=1;i<=rowIndex;i++) {
    		int pre = 1;
    		for (int j=1;j<i;j++) {
    			int cur = ta.get(j);
    			ta.set(j, pre + cur);
    			pre = cur;
    		}
    		ta.add(1);
    	}
    	return ta;
    }
}
