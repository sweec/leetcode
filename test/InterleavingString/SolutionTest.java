package InterleavingString;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testIsInterleave() {
		Solution s = new Solution();
		String s1 = "aabcc", s2 = "dbbca";
		String[] s3s = {"aadbbcbcac", "aadbbbaccc"};
		boolean[] ans = {true, false};
		for (int i=0;i<s3s.length;i++)
			assertEquals("result not agree", ans[i], s.isInterleave(s1, s2, s3s[i]));
		String ss1 = "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa";
		String ss2 = "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab";
		String ss3 = "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";
		assertEquals("result not agree", false, s.isInterleave(ss1, ss2, ss3));
	}
}
