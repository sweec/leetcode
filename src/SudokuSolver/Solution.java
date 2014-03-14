package SudokuSolver;

import java.util.ArrayList;

public class Solution {
    public void solveSudoku(char[][] board) {
    	int n = 9, ALLOWBITS = 0x3FE;
    	if (board == null || board.length != n)
    		return;
    	for (int i=0;i < n;i++)
    		if (board[i] == null || board[i].length != n)
    			return;
        int[] row = new int[n], col = new int[n], block = new int[n];
        ArrayList<Integer> emptycells = new ArrayList<Integer>();
        for (int i=0;i<n;i++)
        	for (int j=0;j<n;j++) {
        		char c = board[i][j];
        		if (c == '.')
        			emptycells.add(i*n+j);
        		else {
        			int bit = 1 << (c - '0');
        			if ((row[i] & bit) > 0)
        				return;
        			else
        				row[i] |= bit;
        			if ((col[j] & bit) > 0)
        				return;
        			else
        				col[j] |= bit;
        			int bn = (i/3)*3 + j/3;
        			if ((block[bn] & bit) > 0)
        				return;
        			else
        				block[bn] |= bit;
        		}
        	}
        if (emptycells.isEmpty())
        	return;
        int size = emptycells.size();
        int index = 0;
        while (index < size && index >=0) {
        	int ei = emptycells.get(index);
        	int i = ei/n, j = ei - i*n, bn = (i/3)*3 + j/3;
        	char c = board[i][j];
        	if (c == '.') {
        		int allow = ALLOWBITS^(row[i]|col[j]|block[bn]);
        		if (allow == 0) {
        			index--;
        			continue;
        		} else {
        			int num = 1;
        			for (;num<n+1;num++)
        				if ((allow & (1<<num)) > 0)
        					break;
        			board[i][j] = (char)('0' + num);
        			int bit = 1 << num;
        			row[i] |= bit; col[j] |= bit; block[bn] |= bit;
        			index++;
        			continue;
        		}
        	} else {
        		int num = c - '0';
        		int bit = 1 << num;
        		int allow = ALLOWBITS^(row[i]|col[j]|block[bn]);
        		row[i] ^= bit; col[j] ^= bit; block[bn] ^= bit;
        		if (allow < bit) {
        			board[i][j] = '.';
        			index--;
        			continue;
        		} else {
        			num++;
        			for (;num<n+1;num++)
        				if ((allow & (1<<num)) > 0)
        					break;
        			board[i][j] = (char)('0' + num);
        			bit = 1 << num;
        			row[i] |= bit; col[j] |= bit; block[bn] |= bit;
        			index++;
        			continue;
        		}
        	}
        }
    }
}
