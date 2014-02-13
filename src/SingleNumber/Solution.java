package SingleNumber;

public class Solution {
    public int singleNumber(int[] A) {
        if (A == null || A.length < 1)
        	return 0;
        int num = 0;
        for (int d:A)
        	num ^= d;
        return num;
    }
}
