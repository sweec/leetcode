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
        if (x < 0 && n % 2 == 1)
        	negative = true;
        x = Math.abs(x);
        if (n < 0) {
        	x = 1/x;
        	n = -n;
        }
        double p = x;
        if (x != 1) {
            for (int i=1;i<n;i++) {
        	    if (p == Double.MAX_VALUE) break;
        	    if (p == 0) break;
        	    p *= x;
            }
        }
        if (negative)
        	return -p;
        else
        	return p;
    }
    
    public static void main(String[] args) {
    	System.out.print((-Double.MAX_VALUE)+" "+(1+Double.MAX_VALUE)+" "+(Double.MIN_VALUE*0.1)+" "+(1/Double.MAX_VALUE));
    }
}
