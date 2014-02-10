package MedianOfTwoSortedArrays;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testFindMedianSortedArrays() {
		Solution s = new Solution();
		int[] A = {1, 5, 10, 12}, B = {0, 3, 9, 11};
		assertEquals("The median value is not correct", new Double(7), new Double(s.findMedianSortedArrays(A, B)));
		int[] C = {1}, D = {0, 3, 9, 11};
		assertEquals("The median value is not correct", new Double(3), new Double(s.findMedianSortedArrays(C, D)));
		int[] E = {1}, F = {0, 3, 9};
		assertEquals("The median value is not correct", new Double(2), new Double(s.findMedianSortedArrays(E, F)));
		int[] G = {1, 2}, H = {0, 3, 9};
		assertEquals("The median value is not correct", new Double(2), new Double(s.findMedianSortedArrays(G, H)));
		int[] I = {1, 2}, J = {0, 3, 9, 11};
		assertEquals("The median value is not correct", new Double(2.5), new Double(s.findMedianSortedArrays(I, J)));
		int[] K = {}, L = {1};
		assertEquals("The median value is not correct", new Double(1), new Double(s.findMedianSortedArrays(K, L)));
	}
}