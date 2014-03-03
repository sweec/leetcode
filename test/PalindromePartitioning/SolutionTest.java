package PalindromePartitioning;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testPartition() {
		Solution s = new Solution();
		String str = "aab";
		ArrayList<ArrayList<String>> ps = s.partition(str);
		String[][] answer = {{"aa", "b"}, {"a", "a", "b"}};
		for (int i=0;i<answer.length;i++) {
			assertEquals("Palindrome number not agree", answer[i].length, ps.get(i).size());
			for (int j=0;j<answer[i].length;j++)
				assertEquals("Palindrome not agree", answer[i][j], ps.get(i).get(j));
		}
	}

}
