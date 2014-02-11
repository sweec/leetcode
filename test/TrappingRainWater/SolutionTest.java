package TrappingRainWater;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testTrap() {
		int[] A = {0,1,0,2,1,0,1,3,2,1,2,1,2};
		Solution s = new Solution();
		assertEquals("Trapping rain water not correct", 7, s.trap(A));
	}

}
