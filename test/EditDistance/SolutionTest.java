package EditDistance;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testMinDistance() {
		Solution s = new Solution();
		String[] word1s = {"a123", "a123"}, word2s = {"3", "3eda"};
		int[] eds = {3, 4};
		for (int i=0;i<eds.length;i++)
			assertEquals("Edit distance not agree", eds[i], s.minDistance(word1s[i], word2s[i]));
	}

}
