package PowXn;

public class Solution {
    public double pow(double x, int n) {
        if (n == 0)
        	return 1;
        if (x == 0) {
        	if (n > 0)
        		return 0;
        	else
        		return Double.POSITIVE_INFINITY;
        }
        boolean negative = false;
        if (x < 0 && (n&1) > 0)
        	negative = true;
        x = Math.abs(x);
        if (n < 0) {
        	x = 1/x;
        	n = -n;
        }
        if (x != 1) {
            double p = 1, cur = x;
            int e = 0;
            while ((e < Integer.SIZE) && n >= (1<<e)) {
            	if ((n&(1<<e)) > 0) {
            		p *= cur;
            		if (p == Double.MAX_VALUE) break;
            		if (p == 0) break;
            	}
        	    e++;
        	    cur *= cur;
            }
            x = p;
        }
        if (negative)
        	return -x;
        else
        	return x;
    }
}
