package MaximumSubarray;

public class Solution {
    public int maxSubArray(int[] A) {
        if (A == null || A.length < 1)
        	return 0;
        int max = A[0], sum = max;
        for (int i=1;i<A.length;i++) {
        	int next = sum + A[i];
        	if (next < sum) {
        		if (max < sum)
        			max = sum;
        		if (next < 0)
        			sum = A[i];
        		else
        			sum = next;
        	} else {
        		if (sum < 0)
        			sum = A[i];
        		else
        			sum = next;
        	}
        }
        if (max < sum)
        	max = sum;
        return max;
    }
}
