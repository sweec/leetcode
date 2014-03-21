package SubstringWithConcatenationOfAllWords;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testFindSubstring() {
		Solution s = new Solution();
		String S = "barfoothefoobarman";
		String[] L = {"foo", "bar"};
		int[] ans = {0, 9};
		ArrayList<Integer> list = s.findSubstring(S, L);
		assertEquals("answer size not agree", ans.length, list.size());
		for (int i=0;i<ans.length;i++)
			assertEquals("answer not agree", (Integer)ans[i], list.get(i));
		String S2 = "aaa";
		String[] L2 = {"a", "a"};
		int[] ans2 = {0, 1};
		ArrayList<Integer> list2 = s.findSubstring(S2, L2);
		assertEquals("answer size not agree", ans2.length, list2.size());
		for (int i=0;i<ans2.length;i++)
			assertEquals("answer not agree", (Integer)ans2[i], list2.get(i));
	}

}
