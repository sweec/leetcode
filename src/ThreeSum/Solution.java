package ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
    	ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
    	if (num == null || num.length < 3)
    		return results;
    	Arrays.sort(num);
    	int last = num[0]-1;
    	for (int i = 0;i < num.length-2;i++) {
    		if (num[i] == last) continue;
        	if (num[i]+num[i+1]+num[i+2] > 0)
        		break;
    		last = num[i];
    		threeSum(num, i, results);
    	}
    	return results;
    }
    
    private void threeSum(int[] num, int beg, ArrayList<ArrayList<Integer>> results) {
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	map.put(num[beg+1], beg+1);
    	int target = -num[beg];
    	int last = num[beg+1];
    	boolean repeated = false;
    	for (int i = beg+2;i < num.length;i++) {
    		if (num[beg+1] + num[i] > target)
    			break;
    		if (num[i] == last) {
    			if (repeated)
    				continue;
    			repeated = true;
    			if (last+last != target)
    				continue;
    		} else {
    			last = num[i];
    			repeated = false;
    		}
    		Integer index = map.get(target - num[i]);
    		if (index != null) {
    			ArrayList<Integer> r = new ArrayList<Integer>();
    			r.add(-target);
    			r.add(num[index]);
    			r.add(num[i]);
    			results.add(r);
    		}
    		if (!repeated)
    			map.put(num[i], i);
    	}
    }
 }
