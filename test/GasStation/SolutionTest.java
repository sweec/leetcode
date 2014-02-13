package GasStation;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testCanCompleteCircuit() {
		int[] gas = {2, 4}, cost = {3, 4};
		Solution s = new Solution();
		assertEquals("Start index is not correct", -1, s.canCompleteCircuit(gas, cost));
	}

}
