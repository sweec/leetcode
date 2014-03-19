package WordSearch;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testExist() {
		Solution s = new Solution();
		char[][] board = {"ABCE".toCharArray(), "SFCS".toCharArray(), "ADEE".toCharArray()};
		String[] words = {"ABCCED", "SEE", "ABCB"};
		boolean[] ans = {true, true, false};
		for (int i=0;i<words.length;i++)
			assertEquals("search result not agree", ans[i], s.exist(board, words[i]));
	}

}
