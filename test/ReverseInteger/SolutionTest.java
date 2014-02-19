package ReverseInteger;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testReverse() {
		Solution s = new Solution();
		int[] A = {123, -123, 0};
		int[] B = {321, -321, 0};
		for (int i=0;i<A.length;i++)
			assertEquals("reverse "+A[i]+" is wrong", B[i], s.reverse(A[i]));
	}

}
