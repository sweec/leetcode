package SortColors;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSortColors() {
		Solution s = new Solution();
		int[] A = {1, 0, 2, 2, 0, 1};
		int[] B = {0, 0, 1, 1, 2, 2};
		s.sortColors(A);
		for (int i=0;i<A.length;i++)
			assertEquals((i+1)+"th color not corret", B[i], A[i]);
		int[] A2 = {1, 0, 0};
		int[] B2 = {0, 0, 1};
		s.sortColors(A2);
		for (int i=0;i<A2.length;i++)
			assertEquals((i+1)+"th color not corret", B2[i], A2[i]);
	}

}
