package CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
    	ArrayList<ArrayList<Integer>> combs = new ArrayList<ArrayList<Integer>>();
    	if (num == null || num.length < 1)
    		return combs;
    	Arrays.sort(num);
    	if (num[0] > target)
    		return combs;
    	int index = num.length - 1;
    	while (index > 0 && num[index] > target)
    		index--;
    	combinationSum(num, index, target, combs);
    	return combs;
    }
    
    private void combinationSum(int[] num, int index, int target, ArrayList<ArrayList<Integer>> combs) {
		int count = target / num[index];
    	int i = index - 1;
    	while (i >= 0 && num[i] == num[index])
    		i--;
    	count = Math.min(count, index-i);
    	if (i >= 0) {
    		int t = target;
    		combinationSum(num, i, target, combs);
    		for (int j=1;j<=count;j++) {
    			int size = combs.size();
    			t -= num[index];
    			if (t == 0)
    				break;
    			combinationSum(num, i, t, combs);
    			for (int k=size;k<combs.size();k++) {
    				ArrayList<Integer> comb = combs.get(k);
    				for (int l=0;l<j;l++)
    					comb.add(num[index]);
    			}
    		}
    	}
    	if (target == num[index]*count) {
    		 ArrayList<Integer> comb = new ArrayList<Integer>();
    		 for (int j=0;j<count;j++)
    			 comb.add(num[index]);
    		 combs.add(comb);
    	}
    }
}
