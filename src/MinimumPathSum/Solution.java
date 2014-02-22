package MinimumPathSum;

public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1)
        	return 0;
        int m = grid.length, n = grid[0].length;
        int[][] ps = new int[m][n];
        ps[0][0] = grid[0][0];
        for (int i=1;i<m;i++)
        	ps[i][0] = ps[i-1][0] + grid[i][0];
        for (int i=1;i<n;i++)
        	ps[0][i] = ps[0][i-1] + grid[0][i];
        for (int i=1;i<m;i++)
        	for (int j=1;j<n;j++)
        		ps[i][j] = Math.min(ps[i-1][j], ps[i][j-1]) + grid[i][j];
        return ps[m-1][n-1];
    }
}
