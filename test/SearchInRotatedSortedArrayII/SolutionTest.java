package SearchInRotatedSortedArrayII;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() {
		int[] A = {4, 5, 6, 7, 0, 1, 2};
		Solution s = new Solution();
		assertEquals("Search should return false", false, s.search(A, 10));
		assertEquals("Search should return true", true, s.search(A, 0));
		assertEquals("Search should return true", true, s.search(A, 7));
		int[] B = {2, 2, 3, 2, 2};
		assertEquals("Search should return false", false, s.search(B, 10));
		assertEquals("Search should return true", true, s.search(B, 3));
		assertEquals("Search should return true", true, s.search(B, 2));
		int[] C = {2, 2, 3, 3, 1, 1, 2, 2};
		assertEquals("Search should return false", false, s.search(C, 10));
		assertEquals("Search should return true", true, s.search(C, 3));
		assertEquals("Search should return true", true, s.search(C, 2));
		assertEquals("Search should return true", true, s.search(C, 1));
	}

}
