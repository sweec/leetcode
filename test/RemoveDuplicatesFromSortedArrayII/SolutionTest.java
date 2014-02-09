package RemoveDuplicatesFromSortedArrayII;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() {
		int[] A = {1, 1, 1, 2, 2, 3};
		int length = new Solution().removeDuplicates(A);
		assertEquals("New array length not equal to 5", 5, length);
		assertEquals("2nd element is not 1", 1, A[1]);
		assertEquals("4th element is not 2", 2, A[3]);
	}

}
