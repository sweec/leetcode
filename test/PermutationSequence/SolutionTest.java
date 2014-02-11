package PermutationSequence;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testGetPermutation() {
		Solution s = new Solution();
		String[] permutations = {"123", "132", "213", "231", "312", "321"};
		int n = 3;
		for (int k = 1;k <= 6;k++)
			assertEquals("Permutation "+k+" is not correct", permutations[k-1], s.getPermutation(n, k));
	}

}
