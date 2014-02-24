package SearchA2DMatrix;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSearchMatrix() {
		Solution s = new Solution();
		int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
		int target = 12;
		assertEquals("Wrong result", false, s.searchMatrix(matrix, target));
	}

}
