package NQueensII;

public class Solution {
    public int totalNQueens(int n) {
        if (n < 1)
        	return 0;
        int[][] board = new int[n][n];
        return totalQueens(n, n*n, board);
    }
    
    private int totalQueens(int m, int free, int[][] board) {
    	if (m == 1)
    		return free;
    	int sum = 0;
    	int n = board.length;
    	int i=n-m;
    	for (int j=0;j<n;j++) {
    		if (board[i][j] == 0) {
    			for (int k=0;k<n;k++) {
    				if (board[i][k] == 0) {
    					board[i][k] = m;
    					free--;
    				}
    				if (board[k][j] == 0) {
    					board[k][j] = m;
    					free--;
    				}
    				int jj = j+k-i;
    				if (jj>=0 && jj<n && board[k][jj] == 0) {
    					board[k][jj] = m;
    					free--;
    				}
    				jj = j+i-k;
    				if (jj>=0 && jj<n && board[k][jj] == 0) {
    					board[k][jj] = m;
    					free--;
    				}
    			}
    			if (free >= m-1)
    				sum += totalQueens(m-1, free, board);
    			for (int k=n-m;k<n;k++)
    				for (int l=0;l<n;l++)
    					if (board[k][l] == m) {
    						board[k][l] = 0;
    						free++;
    					}
    		}
    	}
    	return sum;
    }
}
