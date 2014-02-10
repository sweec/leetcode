package SearchInRotatedSortedArray;

public class Solution {
    public int search(int[] A, int target) {
    	if (A == null)
    		return -1;
        int aIndex = 0, bIndex = A.length - 1;
        if (A[aIndex] == target)
        	return aIndex;
        if (A[bIndex] == target)
        	return bIndex;
        boolean rotated = true;
        if (A[bIndex] > A[aIndex])
        	rotated = false;
        while (aIndex < bIndex) {
        	int mIndex = (aIndex + bIndex)/2;
        	if (mIndex == aIndex)
        		break;
        	int a = A[aIndex], m = A[mIndex], b = A[bIndex];
        	if (m == target)
        		return mIndex;
        	if (rotated) {	// search in rotated part
        		if (m > a) {
        			if (target > m || target < b) {
        				aIndex = mIndex;
        			} else {
        				bIndex = mIndex;
        				rotated = false;
        			}
        		} else {
        			if (target < m || target > a) {
        				bIndex = mIndex;
        			} else {
        				aIndex = mIndex;
        				rotated = false;
        			}
        		}
        	} else {	// search in not rotated part
        		if (target > m)
        			aIndex = mIndex;
        		else
        			bIndex = mIndex;
        	}
        }
        return -1;
    }
}