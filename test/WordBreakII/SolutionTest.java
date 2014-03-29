package WordBreakII;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testWordBreak() {
		Solution s = new Solution();
		String str = "catsanddog";
		String[] words = {"cat", "cats", "and", "sand", "dog"};
		HashSet<String> dict = new HashSet<String>();
		for (String w:words)
			dict.add(w);
		String[] ans = {"cat sand dog", "cats and dog"};
		ArrayList<String> sentences = s.wordBreak(str, dict);
		assertEquals("Sentence number not agree", ans.length, sentences.size());
		for (int i=0;i<ans.length;i++)
			assertEquals("Sentence not agree", ans[i], sentences.get(i));
	}

}
