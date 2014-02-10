package SearchInRotatedSortedArrayII;

public class Solution {
    public boolean search(int[] A, int target) {
    	if (A == null)
    		return false;
    	return search(A, 0, A.length - 1, target);
    }
    
    private boolean search(int[] A, int aIndex, int bIndex, int target) {
        if (A[aIndex] == target)
        	return true;
        if (A[bIndex] == target)
        	return true;
        boolean rotated = true;
        if (A[bIndex] > A[aIndex]) {
            if (A[aIndex] > target || A[bIndex] < target)
            	return false;
        	rotated = false;
        }
        while (aIndex < bIndex) {
        	int mIndex = (aIndex + bIndex)/2;
        	if (mIndex == aIndex)
        		break;
        	int a = A[aIndex], m = A[mIndex], b = A[bIndex];
        	if (m == target)
        		return true;
        	if (rotated) {	// search in rotated part
        		if (m > a) {
        			if (target > m || target < b) {
        				aIndex = mIndex;
        			} else {
        				bIndex = mIndex;
        				rotated = false;
        			}
        		} else if (m < a) {
        			if (target < m || target > a) {
        				bIndex = mIndex;
        			} else {
        				aIndex = mIndex;
        				rotated = false;
        			}
        		} else if (m > b) {
        			if (target > m || target < b) {
        				aIndex = mIndex;
        			} else
        				break;
        		} else {	// a = m = b, no half can be skipped
        			if (search(A, aIndex, mIndex-1, target))
        				return true;
        			if (search(A, mIndex+1, bIndex, target))
        				return true;
        			return false;
        		}
        	} else {	// search in not rotated part
        		if (target > m)
        			aIndex = mIndex;
        		else
        			bIndex = mIndex;
        	}
        }
        return false;
    }
    
}