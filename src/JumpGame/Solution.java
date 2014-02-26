package JumpGame;

public class Solution {
    public boolean canJump(int[] A) {
        if (A == null || A.length < 2)
        	return true;
        int len = A.length;
        int index = 0;
        while (index < len-1 && A[index] > 0)
        	index += A[index];
        if (index >= len-1)
        	return true;
        return false;
    }
}
