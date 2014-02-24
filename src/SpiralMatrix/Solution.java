package SpiralMatrix;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
    	ArrayList<Integer> so = new ArrayList<Integer>();
    	if (matrix == null || matrix.length < 1 || matrix[0].length < 1)
    		return so;
    	int x1 = 0, y1 = 0, x2 = matrix.length, y2 = matrix[0].length;
    	while (x1 < x2 && y1 < y2) {
    		for (int j=y1;j<y2;j++)
    			so.add(matrix[x1][j]);
    		for (int i=x1+1;i<x2;i++)
    			so.add(matrix[i][y2-1]);
    		if (x1 != x2-1)
    			for (int j=y2-2;j>=y1;j--)
    				so.add(matrix[x2-1][j]);
    		if (y1 != y2-1)
    			for (int i=x2-2;i>x1;i--)
    				so.add(matrix[i][y1]);
    		x1++;
    		y1++;
    		x2--;
    		y2--;
    	}
    	return so;
    }
}
