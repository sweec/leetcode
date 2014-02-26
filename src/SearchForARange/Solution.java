package SearchForARange;

public class Solution {
    public int[] searchRange(int[] A, int target) {
        if (A == null || A.length < 1)
        	return new int[]{-1, -1};
        int len = A.length;
        if (A[0] > target || A[len-1] < target)
        	return new int[]{-1, -1};
        int beg = -1;
        int a = 0, b = len - 1;
    	if (A[a] == target)
    		beg = a;
    	else
    		do {
    			int m = (a+b)/2;
    			if (m == a) {
    				if (A[b] == target)
    					beg = b;
    				break;
    			}
    			if (A[m] < target)
    				a = m;
    			else
    				b = m;
    		} while (true);
        if (beg < 0)
        	return new int[]{-1, -1};
        int end = beg;
        a = beg; b = len - 1;
    	if (A[b] == target)
    		return new int[]{a, b};
        do {
        	int m = (a+b)/2;
        	if (m == a) {
        		end = a;
        		break;
        	}
        	if (A[m] > target)
        		b = m;
        	else
        		a = m;
        } while (true);
        return new int[]{beg, end};
    }
}
