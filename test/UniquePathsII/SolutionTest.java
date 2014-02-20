package UniquePathsII;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testUniquePathsWithObstacles() {
		Solution s = new Solution();
		int[][] grid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
		assertEquals("Get wrong unique paths", 2, s.uniquePathsWithObstacles(grid));
	}

}
