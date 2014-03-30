package SurroundedRegions;

import java.util.HashSet;
import java.util.Stack;

public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length < 3 || board[0].length < 3)
        	return;
        int m = board.length, n = board[0].length;
        HashSet<Integer> map = new HashSet<Integer>();
        Stack<Integer> queue = new Stack<Integer>(); 
        for (int i=0;i<n;i++)
        	if (board[0][i] == 'O') {
        		map.add(i);
        		queue.push(i);
        	}
        int key = n-1;
        for (int i=1;i<m;i++) {
        	key += n;
        	if (board[i][n-1] == 'O') {
        		map.add(key);
        		queue.push(key);
        	}
        }
        key -= n-1;
        for (int i=n-2;i>0;i--)
        	if (board[m-1][i] == 'O') {
        		map.add(key+i);
        		queue.push(key+i);
        	}
        for (int i=m-1;i>0;i--) {
        	if (board[i][0] == 'O') {
        		map.add(key);
        		queue.push(key);
        	}
        	key -= n;
        }
        while (!queue.isEmpty()) {
        	key = queue.pop();
        	int i = key/n, j = key - i*n;
        	if (i>0 && board[i-1][j] == 'O' && !map.contains(key-n)) {
        		map.add(key-n);
        		queue.push(key-n);
        	}
        	if (i<m-1 && board[i+1][j] == 'O' && !map.contains(key+n)) {
        		map.add(key+n);
        		queue.push(key+n);
        	}
        	if (j>0 && board[i][j-1] == 'O' && !map.contains(key-1)) {
        		map.add(key-1);
        		queue.push(key-1);
        	}
        	if (j<n-1 && board[i][j+1] == 'O' && !map.contains(key+1)) {
        		map.add(key+1);
        		queue.push(key+1);
        	}
        }
        key = n;
        for (int i=1;i<m-1;i++) {
        	for (int j=1;j<n-1;j++)
        		if (board[i][j] == 'O' && !map.contains(key+j))
        			board[i][j] = 'X';
        	key += n;
        }
    }
}
