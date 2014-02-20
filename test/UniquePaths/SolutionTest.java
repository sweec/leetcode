package UniquePaths;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testUniquePaths() {
		Solution s = new Solution();
		int[] ms = {1, 2, 3, 4};
		int[] ns = {4, 3, 2, 1};
		int[] ps = {1, 3, 3, 1};
		for (int i=0;i<ms.length;i++)
			assertEquals("Get wrong unique paths for "+ms[i]+"x"+ns[i], ps[i], s.uniquePaths(ms[i], ns[i]));
	}

}
