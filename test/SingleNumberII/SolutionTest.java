package SingleNumberII;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSingleNumber() {
		int[] A = {3,3,1,3, 2, 2, 2};
		Solution s = new Solution();
		assertEquals("Sinngle number is not correct", 1, s.singleNumber(A));
	}

}
