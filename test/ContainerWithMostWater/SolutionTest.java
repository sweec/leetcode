package ContainerWithMostWater;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testMaxArea() {
		Solution s = new Solution();
		int[][] height = {{2, 1, 3, 2, 4, 1}, {2, 3, 10, 5, 7, 8, 9}};
		int[] max = {8, 36};
		for (int i=0;i<height.length;i++)
			assertEquals("Most water is wrong", max[i], s.maxArea(height[i]));
	}

}
