package JumpGameII;

public class Solution {
    public int jump(int[] A) {
        if (A == null || A.length < 2)
        	return 0;
        int len = A.length;
        int beg = 0, end = 0;
        int step = 0;
        do {
        	step++;
        	int nextbeg = end+1, nextend = end;
        	for (int i=beg;i<=end;i++) {
        		int max = i+A[i];
        		if (max >= len-1)
        			return step;
        		if (max > nextend)
        			nextend = max;
        	}
        	if (nextbeg > nextend)
        		return -1;
        	beg = nextbeg;
        	end = nextend;
        } while (true);
    }
}
