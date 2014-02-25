package NQueensII;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testTotalNQueens() {
		Solution s = new Solution();
		int[] ns = {1, 2, 3, 4};
		int[] totals = {1, 0, 0, 2};
		for (int i=0;i<ns.length;i++)
			assertEquals((i+1)+" queens give wrong result", totals[i], s.totalNQueens(ns[i]));
	}

}
