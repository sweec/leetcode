package WordSearch;

import java.util.HashSet;

public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board[0].length < 1)
        	return false;
        if (word == null || word.isEmpty())
        	return false;
        int m = board.length, n = board[0].length, len = word.length();
        if (len > m*n)
        	return false;
        HashSet<Integer> set = new HashSet<Integer>();
        char c = word.charAt(0);
        for (int i=0;i<m;i++)
        	for (int j=0;j<n;j++) {
        		if (board[i][j] == c) {
        			set.add(i*n+j);
        			if (exist(board, word, 1, i, j, set))
        				return true;
        			set.remove(i*n+j);
        		}
        	}
        return false;
    }
    
    private boolean exist(char[][] board, String word, int beg, int i, int j, HashSet<Integer> set) {
    	if (beg == word.length())
    		return true;
    	char c = word.charAt(beg);
    	int m = board.length, n = board[0].length;
    	int[] xs = {i-1, i, i, i+1}, ys = {j, j-1, j+1, j};
    	for (int k=0;k<xs.length;k++) {
    		int x = xs[k], y = ys[k];
    		if (x>=0 && x<m && y>=0 && y<n
    				&& board[x][y]==c && !set.contains(x*n+y)) {
    			set.add(x*n+y);
    			if (exist(board, word, beg+1, x, y, set))
    				return true;
    			set.remove(x*n+y);
    		}
    	}
    	return false;
    }
}
