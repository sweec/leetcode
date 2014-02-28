package CombinationSum;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testCombinationSum() {
		Solution s = new Solution();
		int[] candidates = {2, 3, 3, 6, 6, 7};
		int target = 7;
		int[][] answer = {{2, 2, 3}, {7}};
		ArrayList<ArrayList<Integer>> combs = s.combinationSum(candidates, target);
		for (int i=0;i<answer.length;i++) {
			assertEquals("Size is wrong for answer "+(i+1), answer[i].length, combs.get(i).size());
			for (int j=0;j<answer[i].length;j++)
				assertEquals((j+1)+"th value is wrong at answer "+(i+1), (Integer)answer[i][j], combs.get(i).get(j));
		}
		int[] candidates2 = {1, 2};
		int target2 = 3;
		int[][] answer2 = {{1, 1, 1}, {1, 2}};
		ArrayList<ArrayList<Integer>> combs2 = s.combinationSum(candidates2, target2);
		for (int i=0;i<answer2.length;i++) {
			assertEquals("Size is wrong for answer "+(i+1), answer2[i].length, combs2.get(i).size());
			for (int j=0;j<answer2[i].length;j++)
				assertEquals((j+1)+"th value is wrong at answer "+(i+1), (Integer)answer2[i][j], combs2.get(i).get(j));
		}
	}

}
