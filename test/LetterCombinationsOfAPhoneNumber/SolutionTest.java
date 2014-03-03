package LetterCombinationsOfAPhoneNumber;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testLetterCombinations() {
		Solution s = new Solution();
		String digits = "23";
		String[] answer = {"ad", "bd", "cd", "ae", "af", "be", "bf", "ce", "cf"};
		ArrayList<String> combs = s.letterCombinations(digits);
		assertEquals("size is wrong", answer.length, combs.size());
		for (int i=0;i<answer.length;i++)
			assertEquals((i+1)+"th string not agree", answer[i], combs.get(i));
	}

}
