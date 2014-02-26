package Subsets;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSubsets() {
		Solution s = new Solution();
		int[] S = {1, 3, 2};
		int[][] answer = {{}, {1}, {2}, {1, 2}, {3}, {1, 3}, {2, 3}, {1, 2, 3}};
		ArrayList<ArrayList<Integer>> sets = s.subsets(S);
		for (int i=0;i<answer.length;i++) {
			assertEquals("Size is wrong for set "+(i+1), answer[i].length, sets.get(i).size());
			for (int j=0;j<answer[i].length;j++)
				assertEquals((j+1)+"th value is wrong at set "+(i+1), (Integer)answer[i][j], sets.get(i).get(j));
		}
	}

}
