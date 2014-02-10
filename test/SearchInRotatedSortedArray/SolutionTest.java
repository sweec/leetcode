package SearchInRotatedSortedArray;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSearch() {
		int[] A = {4, 5, 6, 7, 0, 1, 2};
		Solution s = new Solution();
		assertEquals("Search should return -1", -1, s.search(A, 10));
		assertEquals("Search should return 4", 4, s.search(A, 0));
		assertEquals("Search should return 3", 3, s.search(A, 7));
		int[] B = {1, 2, 3, 4, 5};
		assertEquals("Search should return -1", -1, s.search(B, 10));
		assertEquals("Search should return 4", 4, s.search(B, 5));
		assertEquals("Search should return 1", 1, s.search(B, 2));
	}

}
