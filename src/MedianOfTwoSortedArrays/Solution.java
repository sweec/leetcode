package MedianOfTwoSortedArrays;

public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
    	if (A == null && B == null)
    		return 0;
    	if (A == null || A.length == 0)
    		return getMedianInRange(B, 0, B.length);
    	if (B == null || B.length == 0)
    		return getMedianInRange(A, 0, A.length);
    	
    	// we only deal with B.length >= A.length
    	if (A.length > B.length) {
    		int[] temp = A;
    		A = B;
    		B = temp;
    	}
    	
    	int begA = 0, endA = A.length;
    	int begB = 0, endB = B.length;
    	do {
    		double mA = getMedianInRange(A, begA, endA);
    		double mB = getMedianInRange(B, begB, endB);
    		if (mA == mB)
    			return mA;
    		int lengthA = endA - begA;
    		int lengthB = endB - begB;
    		boolean evenA = (lengthA % 2 == 0);
    		boolean evenB = (lengthB % 2 == 0);
    		int offsetA = begA+lengthA/2;
    		int offsetB = begB+lengthB/2;
    		if (lengthA == 1) {
    			if (lengthB == 1)
    				return (mA+mB)/2.0;
    			if (mA > mB) {
    				if (evenB) {
    					int mB2 = B[offsetB];
    					if (mA <= mB2)
    						return mA;
    					else
    						return mB2;
    				} else {
    					int mB2 = B[offsetB+1];
    					if (mA <= mB2)
    						return (mA + mB)/2.0;
    					else
    						return (mB + mB2)/2.0;
    				}
    			} else {
    				if (evenB) {
    					int mB1 = B[offsetB-1];
    					if (mA >= mB1)
    						return mA;
    					else
    						return mB1;
    				} else {
    					int mB1 = B[offsetB-1];
    					if (mA >= mB1)
    						return (mA + mB)/2.0;
    					else
    						return (mB + mB1)/2.0;
    				}
    			}
    		} else if (lengthA == 2) {
				int mA1 = A[begA], mA2 = A[begA+1];
    			if (mA > mB) {
    				if (evenB) {
    					int mB1 = B[offsetB-1];
    					int mB2 = B[offsetB];
    					if (mB2 <= mA1) {
    						if (lengthB == 2 || mA1 <= B[offsetB+1])
    							return (mB2+mA1)/2.0;
    						else
    							return (mB2+B[offsetB+1])/2.0;
    					} else if (mB2 <= mA2) {
    						if (mA1 >= mB1)
    							return (mA1+mB2)/2.0;
    						else
    							return mB;
    					} else
    						return mA;
    				} else {
    					if (mA1 <= mB)
    						return mB;
    					int mB2 = B[offsetB+1];
    					if (mA1 <= mB2)
    						return mA1;
    					else
    						return mB2;
    				}
    			} else {
    				if (evenB) {
    					int mB1 = B[offsetB-1];
    					int mB2 = B[offsetB];
    					if (mB1 >= mA2) {
    						if (lengthB == 2 || mA2 >= B[offsetB-2])
    							return (mA2 + mB1)/2.0;
    						else
    							return (B[offsetB-2] + mB1)/2.0;
    					} else if (mB1 >= mA1) {
    						if (mA2 <= mB2)
    							return (mB1 + mA2)/2.0;
    						else
    							return mB;
    					} else
    						return mA;
    				} else {
    					if (mA2 >= mB)
    						return mB;
    					int mB1 = B[offsetB-1];
    					if (mA2 >= mB1)
    						return mA2;
    					else
    						return mB1;
    				}
    			}
    		} else {
				int step = offsetA - begA;
				if (evenA)
					step--;
    			if (mA > mB) {
    				endA -= step;
    				begB += step;
    			} else {
    				begA += step;
    				endB -= step;
    			}
    		}
    	} while (true);
    }
    
    private double getMedianInRange(int A[], int beg, int end) {
    	if (A == null || A.length == 0)
    		return 0;
    	int length = end - beg;
    	int offset = beg+length/2;
    	if (length % 2 == 0)
    		return (A[offset-1]+A[offset])/2.0;
    	else
    		return A[offset];
    }
}