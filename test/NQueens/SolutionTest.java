package NQueens;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSolveNQueens() {
		Solution s = new Solution();
		int n = 4;
		String[][] answer = {{".Q..", "...Q", "Q...", "..Q."}, {"..Q.", "Q...", "...Q", ".Q.."}};
		ArrayList<String[]> sol = s.solveNQueens(n);
		assertEquals("answer size not agree", answer.length, sol.size());
		for (int i=0;i<answer.length;i++)
			for (int j=0;j<n;j++)
				assertEquals((j+1)+" row's Queen not agree at answer "+(i+1), answer[i][j], sol.get(i)[j]);
	}

}
