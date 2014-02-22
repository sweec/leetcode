package MergeSortedArray;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testMerge() {
		Solution s = new Solution();
		int[] A = {1, 2, 4, 5, 6, 0}, B = {3}, C = {1, 2, 3, 4, 5, 6};
		s.merge(A, 5, B, 1);
		for (int i=0;i<A.length;i++)
			assertEquals((i+1)+"th value is wrong", C[i], A[i]);
	}

}
