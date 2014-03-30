package SurroundedRegions;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSolve() {
		Solution s = new Solution();
		char[][] board = {"XOX".toCharArray(), "XOX".toCharArray(), "XOX".toCharArray()};
		char[][] ans = {"XOX".toCharArray(), "XOX".toCharArray(), "XOX".toCharArray()};
		s.solve(board);
		for (int i=0;i<board.length;i++)
			for (int j=0;j<board[0].length;j++)
				assertEquals("char not agree", ans[i][j], board[i][j]);
		
		char[][] board2 = {"XXXX".toCharArray(), "XOOX".toCharArray(), "XXOX".toCharArray(), "XOXX".toCharArray()};
		char[][] ans2 = {"XXXX".toCharArray(), "XXXX".toCharArray(), "XXXX".toCharArray(), "XOXX".toCharArray()};
		s.solve(board2);
		for (int i=0;i<board2.length;i++)
			for (int j=0;j<board2[0].length;j++)
				assertEquals("char not agree", ans2[i][j], board2[i][j]);
	}

}
