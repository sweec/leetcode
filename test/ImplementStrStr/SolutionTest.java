package ImplementStrStr;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testStrStr() {
		Solution s = new Solution();
		
		String haystack = "This is a string";
		String[] strs1 = {"This", " is", "a", "ing", "This is a string"};
		String[] strs2 = {"hehe", "mis", "ab", "nga"};
		
		for (String needle:strs1)
			if (s.strStr(haystack, needle) == null)
				fail(needle+" is not detected as part of "+haystack);
		for (String needle:strs2)
			if (s.strStr(haystack, needle) != null)
				fail(needle+" is wrongly detected as part of "+haystack);
		
		String haystack2 = "aaab";
		String needle2 = "a";
		if (s.strStr(haystack2, needle2) != "aaab")
			fail(needle2+" is not detected as part of "+haystack2);
		
		String haystack3 = "mississippi";
		String needle3 = "issipi";
		if (s.strStr(haystack3, needle3) != null)
			fail(needle3+" is wrongly detected as part of "+haystack3);
	}

}
