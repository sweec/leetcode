package UniqueBinarySearchTrees;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testNumTrees() {
		Solution s = new Solution();
		int[] ns = {0, 1, 2, 3, 4};
		int[] nums = {0, 1, 2, 5, 14};
		for (int i=0;i<ns.length;i++)
			assertEquals("Get wrong unique tree numbers for "+ns[i], nums[i], s.numTrees(ns[i]));
	}

}
