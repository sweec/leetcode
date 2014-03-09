package SqrtX;

public class Solution {
    public int sqrt(int x) {
        if (x <= 0)
        	return 0;
        int i = 0;
        while ((1L<<(i+i+2)) < x)
        	i++;
        int root = 1<<i;
        long square = 1L<<(i+i);
        for (int j=i;j>=0;j--) {
        	long s = square + ((long)root<<(j+1)) + (1L<<(j+j));
        	if (s == x)
        		return root+(1<<j);
        	if (s < x) {
        		root += (1<<j);
        		square = s;
        	}
        }
        return root;
    }
}
