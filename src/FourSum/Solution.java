package FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
    	ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length < 4)
        	return results;
        Arrays.sort(num);
        int len = num.length;
        if (num[0]+num[1]+num[2]+num[3] > target
        		|| num[len-1]+num[len-2]+num[len-3]+num[len-4] < target)
        	return results;
        int lasti = num[0]-1;
        for (int i = 0;i < num.length-3;i++) {
        	if (num[i] == lasti)
        		continue;
        	else
        		lasti = num[i];
        	if (num[i]+num[i+1]+num[i+2]+num[i+3] > target)
        		break;
        	int lastj = num[i+1]-1;
        	for (int j = i+1;j < num.length-2;j++) {
        		if (num[j] == lastj)
        			continue;
        		else
        			lastj = num[j];
            	if (num[i]+num[j]+num[j+1]+num[j+2] > target)
            		break;
        		fourSum(num, num[i], j, target - num[i] - num[j], results);
        	}
        }
        return results;
    }

    private void fourSum(int[] num, int v1, int beg, int target, ArrayList<ArrayList<Integer>> results) {
    	if (num == null || num.length < 2)
    		return;
    	int len = num.length;
    	if (num[beg]+num[beg+1] > target || num[len-1]+num[len-2] < target)
    		return;
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	map.put(num[beg+1], beg+1);
    	boolean stillValid = true;
    	int last = num[beg+1];
    	for (int i = beg+2;i < len;i++) {
    		if (num[i] == last) {
    			if (!stillValid)
    				continue;
    			else {
    				stillValid = false;
    				if (last+last != target)
    					continue;
    			}
    		} else {
    			last = num[i];
    			stillValid = true;
    		}
    		if (num[i]+num[beg+1] > target)
    			break;
    		Integer index = map.get(target - num[i]);
    		if (index != null) {
    			ArrayList<Integer> r = new ArrayList<Integer>();
    			r.add(v1); r.add(num[beg]); r.add(num[index]); r.add(num[i]);
    			results.add(r);
    			map.remove(target - num[i]);
    		} else
    			map.put(num[i], i);
    	}
    }
 }
