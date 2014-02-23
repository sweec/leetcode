package PascalTriangle;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testGenerate() {
		Solution s = new Solution();
		int numRows = 5;
		int[][] ps = {{1}, {1, 1}, {1, 2, 1}, {1, 3, 3, 1}, {1, 4, 6, 4, 1}};
		ArrayList<ArrayList<Integer>> pas = s.generate(numRows);
		for (int i=0;i<ps.length;i++)
			for (int j=0;j<ps[0].length;j++)
				assertEquals((j+1)+"th value is wrong at layer "+(i+1), (Integer)ps[i][j], pas.get(i).get(j));
	}

}
