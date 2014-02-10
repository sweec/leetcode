package ThreeSum;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testThreeSum() {
		int[] S = {-1, 0, 1, 2, -1, -4};
		Solution s = new Solution();
		ArrayList<ArrayList<Integer>> results = s.threeSum(S);
		assertEquals("Results number is not correct", 2, results.size());
		for (ArrayList<Integer> r:results) {
			int sum = r.get(0)+r.get(1)+r.get(2);
			if (sum != 0)
				fail("("+r.get(0)+" "+r.get(1)+" "+r.get(2)+") do not sum to 0");
		}
	}

}
