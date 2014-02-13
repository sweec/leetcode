package SingleNumberII;

import java.util.HashMap;

public class Solution {
    public int singleNumber(int[] A) {
        if (A == null || A.length < 1)
        	return 0;
        int n = A.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int num = 0, doubleCount = 0;
        for (int i=0;i<n;i++) {
        	int d = A[i];
        	if (!map.containsKey(d)) {
        		map.put(d, 1);
        		num += d;
        	} else {
        		int c = map.get(d)+1;
        		map.put(d, c);
        		if (c == 2) {
        			num -= d;
        			doubleCount++;
        		} else if (c == 3)
        			doubleCount--;
        	}
        	if (doubleCount == n-i-1)
        		return num;
        }
        return num;
    }
}
