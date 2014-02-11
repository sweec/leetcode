package TrappingRainWater;

public class Solution {
    public int trap(int[] A) {
        if (A == null || A.length < 3)
        	return 0;
        int len = A.length;
        int[] sums = new int[len];
        sums[0] = A[0];
        int maxIndex = 0, max = A[0];
        for (int i = 1;i < len;i++) {
        	sums[i] = sums[i-1] + A[i];
        	if (A[i] > max) {
        		max = A[i];
        		maxIndex = i;
        	}
        }
        
        return (trap(A, 0, maxIndex+1, sums, true)
        		+ trap(A, maxIndex, len, sums, false));
    }
    
    private int trap(int[] A, int beg, int end, int[] sums, boolean maxAtRight) {
    	int len = end - beg;
    	if (len < 3)
    		return 0;
    	int nextMaxIndex = -1, nextMax = -1;
    	for (int i = 1;i < len;i++) {
    		int index = -1;
    	 	if (maxAtRight)
    	 		index = end-1-i;
    	 	else
    	 		index = beg+i;
    		if (A[index] >= nextMax) {
    			nextMax = A[index];
    			nextMaxIndex = index;
    		}
    	}
    	if (maxAtRight)
    		return (trap(A, beg, nextMaxIndex+1, sums, true)
    				+ nextMax*(end-1-nextMaxIndex-1)-(sums[end-2]-sums[nextMaxIndex]));
    	else
    		return (nextMax*(nextMaxIndex-beg-1)-(sums[nextMaxIndex-1]-sums[beg])
    				+ trap(A, nextMaxIndex, end, sums, false));
    }
}
