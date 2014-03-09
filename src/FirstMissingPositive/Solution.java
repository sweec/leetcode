package FirstMissingPositive;

public class Solution {
    public int firstMissingPositive(int[] A) {
        if (A == null || A.length < 1)
        	return 1;
        int len = A.length;
        int i = 0;
        while (i < len) {
			int n = A[i];
			if (n>0 && n<=len && A[n-1] != n) {
				if (n < i+1)
					A[n-1] =n;
				else if (n > i+1) {
					A[i] = A[n-1];
					A[n-1] = n;
					i--;
				}
			}
        	i++;
        }
        for (int j=0;j<len;j++)
        	if (A[j] != j+1)
        		return j+1;
        return len+1;
    }
}
