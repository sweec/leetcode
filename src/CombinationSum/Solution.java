package CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
    	ArrayList<ArrayList<Integer>> combs = new ArrayList<ArrayList<Integer>>();
    	if (candidates == null || candidates.length < 1)
    		return combs;
    	Arrays.sort(candidates);
    	if (candidates[0] > target)
    		return combs;
    	int index = candidates.length - 1;
    	while (index > 0 && candidates[index] > target)
    		index--;
    	combinationSum(candidates, index, target, combs);
    	return combs;
    }
    
    private void combinationSum(int[] candidates, int index, int target, ArrayList<ArrayList<Integer>> combs) {
		int count = target / candidates[index];
    	int i = index - 1;
    	while (i >= 0 && candidates[i] == candidates[index])
    		i--;
    	if (i >= 0) {
    		int t = target;
    		combinationSum(candidates, i, target, combs);
    		for (int j=1;j<=count;j++) {
    			int size = combs.size();
    			t -= candidates[index];
    			if (t == 0)
    				break;
    			combinationSum(candidates, i, t, combs);
    			for (int k=size;k<combs.size();k++) {
    				ArrayList<Integer> comb = combs.get(k);
    				for (int l=0;l<j;l++)
    					comb.add(candidates[index]);
    			}
    		}
    	}
    	if (target == candidates[index]*count) {
    		 ArrayList<Integer> comb = new ArrayList<Integer>();
    		 for (int j=0;j<count;j++)
    			 comb.add(candidates[index]);
    		 combs.add(comb);
    	}
    }
}
