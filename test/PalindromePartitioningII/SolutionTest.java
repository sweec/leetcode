package PalindromePartitioningII;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testMinCut() {
		Solution s = new Solution();
		String[] strs = {"aab", "abc", "coder", "fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi"};
		int[] ans = {1, 2, 4, 75};
		for (int i=0;i<strs.length;i++)
			assertEquals("min cut not agree for "+strs[i], ans[i], s.minCut(strs[i]));
	}

}
