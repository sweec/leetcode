package MinimumPathSum;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testMinPathSum() {
		Solution s = new Solution();
		int[][] grid = {{1, 2, 3}, {4, 5, 1}};
		assertEquals("Minimum path sum not correct", 7, s.minPathSum(grid));
	}

}
