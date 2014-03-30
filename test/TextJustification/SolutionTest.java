package TextJustification;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testFullJustify() {
		Solution s = new Solution();
		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		int L = 16;
		String[] ans = {"This    is    an", "example  of text", "justification.  "};
		ArrayList<String> text = s.fullJustify(words, L);
		assertEquals("Text line number not agree", ans.length, text.size());
		for (int i=0;i<ans.length;i++)
			assertEquals("Text not agree", ans[i], text.get(i));
	}

}
