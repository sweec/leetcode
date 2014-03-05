package CombinationSumII;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testCombinationSum() {
		Solution s = new Solution();
		int[] num = {10, 1, 2, 7, 6, 1, 5};
		int target = 8;
		int[][] answer = {{1, 2, 5}, {1, 1, 6}, {2, 6}, {1, 7}};
		ArrayList<ArrayList<Integer>> combs = s.combinationSum2(num, target);
		for (int i=0;i<answer.length;i++) {
			assertEquals("size not agree", answer[i].length, combs.get(i).size());
			for (int j=0;j<answer[i].length;j++)
				assertEquals((j+1)+"th value not agree of comb "+(i+1), (Integer)answer[i][j], combs.get(i).get(j));
		}
	}

}
