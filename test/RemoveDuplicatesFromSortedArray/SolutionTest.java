package RemoveDuplicatesFromSortedArray;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() {
		int[] A = {1, 1, 2};
		int length = new Solution().removeDuplicates(A);
		assertEquals("New array length not equal to 2", 2, length);
		assertEquals("2nd element is not 2", 2, A[1]);
	}

}
