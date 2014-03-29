package DivideTwoIntegers;

public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
        	if (dividend < 0)
        		return Integer.MIN_VALUE;
        	else
        		return Integer.MAX_VALUE;
        }
        if (divisor == 1)
        	return dividend;
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE)
            	return Integer.MAX_VALUE;
        	return -dividend;
        }
        if (divisor == Integer.MIN_VALUE) {
        	if (dividend == Integer.MIN_VALUE)
            	return 1;
        	return 0;
        }
        int sum = 0;
        if (dividend == Integer.MIN_VALUE) {
        	dividend += Math.abs(divisor);
        	sum = 1;
        }
        if (dividend < 0) {
        	dividend = -dividend;
        	divisor = -divisor;
        }
        boolean neg = false;
        if (divisor < 0) {
        	neg = true;
        	divisor = -divisor;
        }
        int bit = 30;
        for (;bit>0;bit--)
        	if (((1<<bit)&divisor) > 0)
        		break;
        for (int i=30-bit;i>=0;i--) {
        	int num = divisor << i;
        	if (dividend >= num) {
        		sum += 1 << i;
        		dividend -= num;
        	}
        }
        if (neg)
        	return -sum;
        else
        	return sum;
    }
}
