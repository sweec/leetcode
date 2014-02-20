package SearchInsertPosition;

public class Solution {
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length < 1)
        	return 0;
        int a = 0, b = A.length-1;
        if (A[a] > target)
        	return 0;
        if (A[b] < target)
        	return b+1;
        if (A[a] == target)
        	return a;
        if (A[b] == target)
        	return b;
        do {
        	int m = (a+b)/2;
        	if (m == a)
        		return b;
        	if (A[m] == target)
        		return m;
        	if (A[m] < target)
        		a = m;
        	else
        		b = m;
        } while (true);
    }
}
