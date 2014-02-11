package ThreeSumClosest;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testThreeSumClosest() {
		int[] num = {-1, 2, 1, -4};
		int target = 1;
		Solution s = new Solution();
		assertEquals("Return value not correct", 2, s.threeSumClosest(num, target));
		target = -10;
		assertEquals("Return value not correct", -4, s.threeSumClosest(num, target));
	}

}
