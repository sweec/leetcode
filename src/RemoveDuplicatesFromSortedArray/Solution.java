package RemoveDuplicatesFromSortedArray;

public class Solution {
    public int removeDuplicates(int[] A) {
    	if (A == null)
    		return 0;
        if (A.length <= 1)
        	return A.length;
        int oldIndex = 1, newIndex = 0;
        while (oldIndex < A.length) {
        	if (A[oldIndex] != A[newIndex]) {
        		newIndex++;
        	    if (newIndex != oldIndex)
        	    	A[newIndex] = A[oldIndex];
        	}
        	oldIndex++;
        }
        return newIndex+1;
    }
}