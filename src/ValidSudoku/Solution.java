package ValidSudoku;

public class Solution {
	private int n = 9, r = 3;
	public boolean isValidSudoku(char[][] board) {
    	// initial validation
    	if (board == null || board.length != n)
    		return false;
    	for (int i = 0;i < n;i++)
    		if (board[i] == null || board[i].length != n)
    			return false;
    	// row valid?
    	for (int i = 0;i < n;i++)
    		if (!isRowValid(board, i))
    			return false;
    	// column valid?
    	for (int i = 0;i < n;i++)
    		if (!isColumnValid(board, i))
    			return false;
    	// block valid?
    	for (int i = 0;i < n;i++)
    		if (!isBlockValid(board, i))
    			return false;
    	/*
    	int[] emptyCells = new int[n*n];
    	int[][] inValidNum = new int[n][n];
    	int index = 0;
    	for (int i = 0;i < n;i++)
    		for (int j = 0;j < n;j++)
    			if (board[i][j] == '.') {
    				emptyCells[index++] = i*n+j;
    				inValidNum[i][j] = getInvalidNum(board, i, j);
    			} else
    				inValidNum[i][j] = (int) (1 << (board[i][j]-'1'));
    	return isNewBoardValid(board, emptyCells, inValidNum, 0);
    	*/
    	return true;
    }
	/*
	private int getInvalidNum(char[][] board, int x, int y) {
		int sum = 0;
		int row = x/r*r, col = y/r*r;
		for (int i = 0;i < n;i++) {
			int num = board[x][i];
			if (num != '.')
				sum |= 1 << (num - '1');
			num = board[i][y];
			if (num != '.')
				sum |= 1 << (num - '1');
			num = board[row+i/r][col+i%r];
			if (num != '.')
				sum |= 1 << (num - '1');
		}
		return (int) sum;
	}
	
    private boolean isNewBoardValid(char[][] board, int[] emptyCells, int[][] inValidNum, int index) {
    	if (index > 0 && (index >= n*n || emptyCells[index] == 0))
    		return true;
    	int i = emptyCells[index]/n, j = emptyCells[index] % n;
    	for (int k = 0;k < n;k++) {
    		if ((inValidNum[i][j] & (1 << k)) > 0)
    			continue;
    		board[i][j] = (char) (((int)'1')+k);
    		
    		if (isRowValid(board, i)
    				&& isColumnValid(board, j)
    				&& isBlockValid(board, (i/r)*r+j/r)
    				&& isNewBoardValid(board, emptyCells, inValidNum, index+1)) {
    			board[i][j] = '.';
    			return true;
    		}
    	}
    	board[i][j] = '.';
    	return false;
    }
    */
    private boolean isRowValid(char[][] board, int row) {
    	int sum = 0;
    	for (int j = 0;j < n;j++) {
    		char c = board[row][j];
    		if (c == '.') {
    			continue;
    		}
    		int num = c - '1';
    		if ((sum & (1 << num)) > 0)
    			return false;
    		else
    			sum |= 1 << num;
    	}
    	return true;
    }
    
    private boolean isColumnValid(char[][] board, int col) {
    	int sum = 0;
    	for (int j = 0;j < n;j++) {
    		char c = board[j][col];
    		if (c == '.') {
    			continue;
    		}
    		int num = c - '1';
    		if ((sum & (1 << num)) > 0)
    			return false;
    		else
    			sum |= 1 << num;
    	}
    	return true;
    }
    
    private boolean isBlockValid(char[][] board, int block) {
    	int sum = 0;
		int y = block%r*r, x = block/r*r;
    	for (int j = 0;j < n;j++) {
    		char c = board[x + j/r][y + j%r];
    		if (c == '.') {
    			continue;
    		}
    		int num = c - '1';
    		if ((sum & (1 << num)) > 0)
    			return false;
    		else
    			sum |= 1 << num;
    	}
    	return true;
    }

}
