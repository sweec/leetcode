package UniquePathsII;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length < 1)
        	return 0;
        if (obstacleGrid[0] == null || obstacleGrid[0].length < 1)
        	return 0;
        if (obstacleGrid[0][0] > 0)
        	return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] ups = new int[m][n];
        ups[0][0] = 1;
        for (int i=1;i<m;i++)
        	if (obstacleGrid[i][0] > 0)
        		ups[i][0] = 0;
        	else
        		ups[i][0] = ups[i-1][0];
    	for (int j=1;j<n;j++)
        	if (obstacleGrid[0][j] > 0)
        		ups[0][j] = 0;
        	else
        		ups[0][j] = ups[0][j-1];
        for (int i=1;i<m;i++)
        	for (int j=1;j<n;j++) {
            	if (obstacleGrid[i][j] > 0)
            		ups[i][j] = 0;
            	else
            		ups[i][j] = ups[i-1][j] + ups[i][j-1];
        	}
        return ups[m-1][n-1];
    }
}
