package SubsetsII;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSubsetsWithDup() {
		Solution s = new Solution();
		int[] num = {1, 2, 2};
		int[][] answer = {{}, {1}, {2}, {2, 2}, {1, 2}, {1, 2, 2}};
		ArrayList<ArrayList<Integer>> sets = s.subsetsWithDup(num);
		for (int i=0;i<answer.length;i++) {
			assertEquals("Size is wrong for set "+(i+1), answer[i].length, sets.get(i).size());
			for (int j=0;j<answer[i].length;j++)
				assertEquals((j+1)+"th value is wrong at set "+(i+1), (Integer)answer[i][j], sets.get(i).get(j));
		}
	}

}
