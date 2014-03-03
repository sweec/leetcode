package NQueens;

import java.util.ArrayList;

public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
    	ArrayList<String[]> s = new ArrayList<String[]>();
        if (n < 1)
        	return s;
        int[][] board = new int[n][n];
        solveNQueens(n, n*n, board, s);
        return s;
    }
    
    private int solveNQueens(int m, int free, int[][] board, ArrayList<String[]> s) {
    	int n = board.length;
    	if (m == 1) {
    		if (free > 0) {
    			StringBuffer[] sbs = new StringBuffer[n];
				String[] strs = new String[n];
    			for (int i=0;i<n-1;i++) {
    				sbs[i] = new StringBuffer();
    				for (int j=0;j<n;j++)
    					if (board[i][j] > n)
    						sbs[i].append('Q');
    					else
    						sbs[i].append('.');
    				strs[i] = sbs[i].toString();
    			}
    			for (int j=0;j<n;j++) {
    				if (board[n-1][j] == 0) {
    					String[] map = new String[n];
    					for (int i=0;i<n-1;i++)
    						map[i] = strs[i];
    					StringBuffer sb = new StringBuffer();
    					for (int i=0;i<n;i++) {
    						if (i == j)
    							sb.append('Q');
    						else
    							sb.append('.');
    					}
    					map[n-1] = sb.toString();
    					s.add(map);
    				}
    			}
    		}
    		return free;
    	}
    	int sum = 0;
    	int i=n-m;
    	for (int j=0;j<n;j++) {
    		if (board[i][j] == 0) {
    			board[i][j] = n+m;
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
    				sum += solveNQueens(m-1, free, board, s);
    			for (int k=n-m;k<n;k++)
    				for (int l=0;l<n;l++)
    					if (board[k][l] == m || board[k][l] == m+n) {
    						board[k][l] = 0;
    						free++;
    					}
    		}
    	}
    	return sum;
    }
}
