package SearchA2DMatrix;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1)
        	return false;
        int m = matrix.length, n = matrix[0].length;
        if (matrix[0][0] > target)
        	return false;
        if (matrix[m-1][n-1] < target)
        	return false;
        if (matrix[0][0] == target || matrix[m-1][n-1] == target)
        	return true;
        int a = 0, b = m * n - 1;
        do {
        	int mid = (a+b)/2;
        	if (mid == a)
        		return false;
        	int val = matrix[mid/n][mid%n];
        	if (val == target)
        		return true;
        	if (val < target)
        		a = mid;
        	else
        		b = mid;
        } while (true);
    }
}
