package ReverseInteger;

public class Solution {
    public int reverse(int x) {
        boolean negative = false;
        if (x < 0) {
        	negative = true;
        	x = -x;
        }
        long num = 0;
        do {
        	int r = x;
        	x = x/10;
        	r -= x*10;
        	num = num*10 + r;
        } while (x > 0);
        if (negative)
        	num = -num;
        if (num > Integer.MAX_VALUE)
        	return Integer.MAX_VALUE;
        if (num < Integer.MIN_VALUE)
        	return Integer.MIN_VALUE;
        return (int) num;
    }
}
