package SpiralMatrix;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSpiralOrder() {
		Solution s = new Solution();
		int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int[] answer = {1, 2, 3, 6, 9, 8, 7, 4, 5};
		ArrayList<Integer> so = s.spiralOrder(matrix);
		for (int i=0;i<so.size();i++)
			assertEquals("wrong value", (Integer)(answer[i]), so.get(i));
	}

}
