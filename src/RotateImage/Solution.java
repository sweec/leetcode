package RotateImage;

public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length < 2)
            return;
        int n = matrix.length, m = n, d = 0;
        while (m > 1) {
            for (int i=0;i<m-1;i++) {
                int temp = matrix[d][d+i];
                matrix[d][d+i] = matrix[d+m-1-i][d];
                matrix[d+m-1-i][d] = matrix[d+m-1][d+m-1-i];
                matrix[d+m-1][d+m-1-i] = matrix[d+i][d+m-1];
                matrix[d+i][d+m-1] = temp;
            }
            m -= 2;
            d++;
        }
    }
 }
