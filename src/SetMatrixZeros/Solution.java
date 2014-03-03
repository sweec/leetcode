package SetMatrixZeros;

import java.util.Arrays;

public class Solution {
	// leetcode discuss has in place solution without use extra space
	
    // can't assume Integer.MAX_VALUE not appear in the matrix
    // use O(n) space instead then
    public void setZeroes(int[][] matrix) {
        if (matrix == null)
            return;
        int m = matrix.length;
        if (m < 1)
            return;
        int n = matrix[0].length;
        if (n < 1)
            return;
        boolean[] zeroColumn = new boolean[n];
        Arrays.fill(zeroColumn, false);
        for (int i=0;i<m;i++) {
            boolean zeroRow = false;
            for (int j=0;j<n;j++) {
                if (matrix[i][j] == 0) {
                    zeroRow = true;
                    zeroColumn[j] = true;
                }
            }
            if (zeroRow)
                for (int j=0;j<n;j++)
                    matrix[i][j] = 0;
        }
        for (int j=0;j<n;j++)
            if (zeroColumn[j])
                for (int i=0;i<m;i++)
                    matrix[i][j] = 0;
    }
}
