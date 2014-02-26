package JumpGameII;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testJump() {
		Solution s = new Solution();
		int[][] As = {{2,3,1,1,4}, {3,2,1,0,4}};
		int[] answer = {2, -1};
		for (int i=0;i<As.length;i++)
			assertEquals("Jump game wrong result", answer[i], s.jump(As[i]));
	}

}
