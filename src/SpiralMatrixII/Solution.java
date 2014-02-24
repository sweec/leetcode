package SpiralMatrixII;

public class Solution {
    public int[][] generateMatrix(int n) {
    	int[][] matrix = new int[n][n];
    	int num = 1;
    	int x1 = 0, y1 = 0, x2 = n, y2 = n;
    	while (x1 < x2 && y1 < y2) {
    		for (int j=y1;j<y2;j++)
    			matrix[x1][j] = num++;
    		for (int i=x1+1;i<x2;i++)
    			matrix[i][y2-1] = num++;
    		if (x1 != x2-1)
    			for (int j=y2-2;j>=y1;j--)
    				matrix[x2-1][j] = num++;
    		if (y1 != y2-1)
    			for (int i=x2-2;i>x1;i--)
    				matrix[i][y1] = num++;
    		x1++;
    		y1++;
    		x2--;
    		y2--;
    	}
    	return matrix;
    }
}
