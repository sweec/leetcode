package FourSum;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testFourSum() {
		int[] num = {1, 0, -1, 0, -2, 2};
		int target = 0;
		Solution s = new Solution();
		ArrayList<ArrayList<Integer>> results = s.fourSum(num, target);
		assertEquals("Results number not correct", 3, results.size());
		for (ArrayList<Integer> r:results)
			assertEquals("sum is not correct", target, r.get(0)+r.get(1)+r.get(2)+r.get(3));
	}

}
