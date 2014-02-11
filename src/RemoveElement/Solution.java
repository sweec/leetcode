package RemoveElement;

public class Solution {
    public int removeElement(int[] A, int elem) {
        if (A == null || A.length < 1)
        	return 0;
        int len = A.length;
        for (int i = 0;i < len; i++) {
        	if (A[i] != elem)
        		continue;
        	len--;
        	while (len > i && A[len] == elem)
        		len--;
        	if (len == i)
        		break;
        	A[i] = A[len];
        }
        return len;
    }
}
