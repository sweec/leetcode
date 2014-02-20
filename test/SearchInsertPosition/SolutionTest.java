package SearchInsertPosition;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSearchInsert() {
		Solution s = new Solution();
		int[][] As = {{1, 3, 5, 6}, {1, 3, 5, 6}, {1, 3, 5, 6}, {1, 3, 5, 6}};
		int[] ts = {5, 2, 7, 0};
		int[] sips = {2, 1, 4, 0};
		for (int i=0;i<As.length;i++)
			assertEquals("Get wrong insert position for "+ts[i], sips[i], s.searchInsert(As[i], ts[i]));
	}

}
