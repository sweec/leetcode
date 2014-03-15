package WordBreak;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testWordBreak() {
		Solution s = new Solution();
		String[] strs = {"leetcod", "leetcode", "leetcodea", "leet", "lee", "e"};
		String[] words = {"leet", "code", "a"};
		HashSet<String> dict = new HashSet<String>();
		for (String w:words)
			dict.add(w);
		boolean[] ans = {false, true, true, true, false, false};
		for (int i=0;i<strs.length;i++)
			assertEquals("result not agree", ans[i], s.wordBreak(strs[i], dict));
	}

}
