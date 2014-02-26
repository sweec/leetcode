package SubsetsII;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
    	ArrayList<ArrayList<Integer>> sets = new ArrayList<ArrayList<Integer>>();
    	if (num == null)
    		return sets;
    	Arrays.sort(num);
    	subsets(num, num.length, sets);
    	return sets;
    }
    
    private void subsets(int[] num, int len, ArrayList<ArrayList<Integer>> sets) {
    	if (len == 0) {
    		ArrayList<Integer> s = new ArrayList<Integer>();
    		sets.add(s);
    	} else {
    		int e = num[len-1];
    		int count = 1;
    		for (int i=len-2;i>=0;i--) {
    			if (num[i] == e)
    				count++;
    			else
    				break;
    		}
    		subsets(num, len-count, sets);
    		int size = sets.size();
    		for (int i=0;i<size;i++) {
    			ArrayList<Integer> s = sets.get(i);
    			for (int j=0;j<count;j++) {
    				s = new ArrayList<Integer>(s);
    				s.add(e);
    				sets.add(s);
    			}
    		}
    	}
    }
}
