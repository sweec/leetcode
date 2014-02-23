package PascalTriangleII;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testGetRow() {
		Solution s = new Solution();
		int rowIndex = 4;
		int[] row = {1, 4, 6, 4, 1};
		ArrayList<Integer> ras = s.getRow(rowIndex);
		for (int i=0;i<row.length;i++)
			assertEquals((i+1)+"th value is wrong at layer "+rowIndex, (Integer)row[i], ras.get(i));
	}

}
