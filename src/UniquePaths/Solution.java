package UniquePaths;

public class Solution {
    public int uniquePaths(int m, int n) {
    	if (m <= 0 || n <= 0)
    		return 0;
    	if (m == 1 || n == 1)
    		return 1;
        int[][] ups = new int[m][n];
        for (int i=1;i<m;i++)
        	ups[i][0] = 1;
        for (int j=1;j<n;j++)
        	ups[0][j] = 1;
        for (int i=1;i<m;i++)
        	for (int j=1;j<n;j++)
        		ups[i][j] = ups[i-1][j] + ups[i][j-1];
        return ups[m-1][n-1];
    }
}
