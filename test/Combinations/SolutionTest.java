package Combinations;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testCombine() {
		Solution s = new Solution();
		int n= 4, k = 2;
		int[][] answer = {{1, 2}, {1, 3}, {2, 3}, {1, 4}, {2, 4}, {3, 4}};
		ArrayList<ArrayList<Integer>> combs = s.combine(n, k);
		for (int i=0;i<answer.length;i++) {
			assertEquals((i+1)+"th combinations size not agree", answer[i].length, combs.get(i).size());
			for (int j=0;j<answer[i].length;j++)
				assertEquals((j+1)+"th value is wrong for combination "+(i+1), (Integer)answer[i][j], combs.get(i).get(j));
		}
	}

}
