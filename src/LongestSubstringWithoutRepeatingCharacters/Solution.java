package LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty())
        	return 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int beg = 0, max = 0, index = 0, len = s.length();
        do {
        	char c = s.charAt(index);
        	if (map.containsKey((int)c)) {
        		max = Math.max(max, index-beg);
        		int loc = map.get((int)c);
        		for (int i=beg;i<=loc;i++)
        			map.remove((int)s.charAt(i));
        		beg = loc+1;
        		if (max >= (len-beg))
        			break;
        	}
        	map.put((int)c, index);
        	index++;
        } while (index<len);
        return Math.max(max, index-beg);
    }
}
