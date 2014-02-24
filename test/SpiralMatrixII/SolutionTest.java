package SpiralMatrixII;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testGenerateMatrix() {
		Solution s = new Solution();
		int n = 3;
		int[][] answer = {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
		int[][] matrix = s.generateMatrix(n);
		for (int i=0;i<n;i++)
			for (int j=0;j<n;j++)
				assertEquals("wrong value", answer[i][j], matrix[i][j]);
	}

}
