package PermutationsII;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testPermuteUnique() {
		Solution s = new Solution();
		int[] num = {1, 2, 3};
		int[][] ps = {{1, 2, 3}, {2, 1, 3}, {1, 3, 2}, {3, 1, 2}, {2, 3, 1}, {3, 2, 1}};
		ArrayList<ArrayList<Integer>> pas = s.permuteUnique(num);
		for (int i=0;i<ps.length;i++)
			for (int j=0;j<ps[i].length;j++)
				assertEquals((j+1)+"th value is wrong at permutation "+(i+1), (Integer)ps[i][j], pas.get(i).get(j));
		int[] num2 = {1, 1, 2};
		int[][] ps2 = {{1, 1, 2}, {1, 2, 1}, {2, 1, 1}};
		ArrayList<ArrayList<Integer>> pas2 = s.permuteUnique(num2);
		for (int i=0;i<ps2.length;i++)
			for (int j=0;j<ps2[i].length;j++)
				assertEquals((j+1)+"th value is wrong at permutation "+(i+1), (Integer)ps2[i][j], pas2.get(i).get(j));
	}

}
