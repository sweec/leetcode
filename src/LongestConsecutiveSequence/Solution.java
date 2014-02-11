package LongestConsecutiveSequence;

import java.util.HashSet;

public class Solution {
    public int longestConsecutive(int[] num) {
        if (num == null || num.length < 1)
        	return 0;
        if (num.length == 1)
        	return 1;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i:num)
        	set.add(i);
        int longest = 1;
        for (int i:num) {
        	if (!set.contains(i))
        		continue;
        	set.remove(i);
        	int j = 1;
        	while (set.contains(i-j)) {
        		set.remove(i-j);
        		j++;
        	}
        	int k = 1;
        	while (set.contains(i+k)) {
        		set.remove(i+k);
        		k++;
        	}
        	if (j+k-1 > longest)
        		longest = j+k-1;
        	if (set.size() <= longest)
        		break;
        }
        return longest;
    }
}