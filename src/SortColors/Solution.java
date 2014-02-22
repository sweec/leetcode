package SortColors;

public class Solution {
    public void sortColors(int[] A) {
    	if (A == null || A.length < 2)
    		return;
    	int[] colors = {0, 1, 2};
    	int a = 0, b = A.length - 1;
    	for (int color:colors) {
    		a = sortOneColor(A, color, a, b);
    		if (a >= b)
    			break;
    	}
    }
    
    private int sortOneColor(int[] A, int color, int a, int b) {
    	do {
    		while (a < b && A[a] == color)
    			a++;
    		if (a >= b)
    			break;
    		while (b > a && A[b] != color)
    			b--;
    		if (b <= a)
    			break;
    		A[b] = A[a];
    		A[a] = color;
    		a++;
    		b--;
    	} while (true);
    	if (A[a] == color)
    		a++;
    	return a;
    }
}
