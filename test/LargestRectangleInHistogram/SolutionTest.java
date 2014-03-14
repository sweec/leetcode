package LargestRectangleInHistogram;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testLargestRectangleArea() {
		Solution s = new Solution();
		int[] height = {2,1,5,6,2,3};
		assertEquals("Largest rectangle area not agree", 10, s.largestRectangleArea(height));
		int[] height2 = new int[8193];
		for (int i=0;i<8193;i++)
			height2[i] = i;
		assertEquals("Largest rectangle area not agree", 16781312, s.largestRectangleArea(height2));
	}

}
