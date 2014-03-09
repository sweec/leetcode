package SqrtX;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSqrt() {
		Solution s = new Solution();
		int[] xs = {1, 2, 4, 256, 100, 1000000, 2147395599};
		int[] as = {1, 1, 2, 16, 10, 1000, 46339};
		for (int i=0;i<xs.length;i++)
			assertEquals("Square root not agree", as[i], s.sqrt(xs[i]));
	}

}
