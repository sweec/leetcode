package NextPermutation;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testNextPermutation() {
		int[] A = {1, 2, 3}, B = {3, 2, 1}, C = {1, 1, 5};
		Solution s = new Solution();
		s.nextPermutation(A); s.nextPermutation(B); s.nextPermutation(C);
		assertEquals("1st of A not correct", 1, A[0]);
		assertEquals("2nd of A not correct", 3, A[1]);
		assertEquals("3rd of A not correct", 2, A[2]);
		assertEquals("1st of B not correct", 1, B[0]);
		assertEquals("2nd of B not correct", 2, B[1]);
		assertEquals("3rd of B not correct", 3, B[2]);
		assertEquals("1st of C not correct", 1, C[0]);
		assertEquals("2nd of C not correct", 5, C[1]);
		assertEquals("3rd of C not correct", 1, C[2]);
	}

}
