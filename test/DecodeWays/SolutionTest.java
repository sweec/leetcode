package DecodeWays;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testNumDecodings() {
		Solution s = new Solution();
		String[] strs = {"0", "100", "1012", "12", "123456", "1213141516"};
		int[] ans = {0, 0, 2, 2, 3, 40};
		for (int i=0;i<strs.length;i++)
			assertEquals("Decode way not agree", ans[i], s.numDecodings(strs[i]));
	}

}
