package TwoSum;

import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
    	if (numbers == null || numbers.length < 2)
    		return null;
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	map.put(numbers[0], 0);
    	for (int i = 1;i < numbers.length;i++) {
    		Integer index = map.get(target - numbers[i]);
    		if (index != null) {
    			int[] indexes = new int[2];
    			indexes[0] = index+1;
    			indexes[1] = i+1;
    			return indexes;
    		} else
    			map.put(numbers[i], i);
    	}
    	return null;
    }
 }
