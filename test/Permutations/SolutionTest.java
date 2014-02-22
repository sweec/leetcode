package Permutations;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testPermute() {
		Solution s = new Solution();
		int[] num = {1, 2, 3};
		int[][] ps = {{1, 2, 3}, {2, 1, 3}, {1, 3, 2}, {3, 1, 2}, {2, 3, 1}, {3, 2, 1}};
		ArrayList<ArrayList<Integer>> pas = s.permute(num);
		for (int i=0;i<ps.length;i++)
			for (int j=0;j<ps[i].length;j++)
				assertEquals((j+1)+"th value is wrong at permutation "+(i+1), (Integer)ps[i][j], pas.get(i).get(j));
	}

}
