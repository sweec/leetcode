package Anagrams;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testAnagrams() {
		Solution s = new Solution();
		String[] strs = {"", "god", "test", "dog", "parliament", "partial men", "Clint Eastwood", "Old West Action", "  "};
		ArrayList<String> anagrams = s.anagrams(strs);
		assertEquals("The number of anagrams found is wrong", 8, anagrams.size());
		for (String str:anagrams)
			System.out.println(str);
	}

}
