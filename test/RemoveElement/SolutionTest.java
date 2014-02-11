package RemoveElement;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testRemoveElement() {
		int[] A = {1, 3, 2, 3, 4};
		int elem = 3;
		Solution s = new Solution();
		assertEquals("New length is not correct", 3, s.removeElement(A, elem));
		int[] B = {1, 3, 2, 3, 4};
		elem = 2;
		assertEquals("New length is not correct", 4, s.removeElement(B, elem));
	}

}
