package MaximalRectangle;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1)
        	return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] count = new int[m][n];
        int max = 0;
        for (int i=0;i<m;i++)
        	for (int j=0;j<n;j++) {
        		if (matrix[i][j] == '0')
        			continue;
        		count[i][j] = 1;
            	if (j > 0)
        			count[i][j] += count[i][j-1];
            	int w = count[i][j];
            	for (int k=i;k>=0;k--) {
            		if (count[k][j] == 0)
            			break;
            		w = Math.min(w, count[k][j]);
            		if (w*(i+1) < max)
            			break;
            		max = Math.max(max, w*(i+1-k));
            	}
        	}
        return max;
    }
}
