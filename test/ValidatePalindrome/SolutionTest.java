package ValidatePalindrome;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testIsPalindrome() {
		Solution s = new Solution();
		String s1 = "A man, a plan, a canal: Panama";
		String s2 = "race a car";
		String s3 = "1a2";
		if (!s.isPalindrome(s1))
			fail(s1+" is palindrome but detected as not");
		if (s.isPalindrome(s2))
			fail(s2+" is not palindrome but detected as is");
		if (s.isPalindrome(s3))
			fail(s3+" is not palindrome but detected as is");
	}

}
