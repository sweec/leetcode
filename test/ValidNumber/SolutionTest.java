package ValidNumber;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testIsNumber() {
		Solution s = new Solution();
		String[] strs = {"0", " 0.1 ", "abc", "1 a", "2e10", " . ", " -. ", "-e58", " 005047e+6"};
		boolean[] valid = {true, true, false, false, true, false, false, false, true};
		for (int i=0;i>strs.length;i++)
			assertEquals("Valid number judge of "+strs[i]+" not correct", valid[i], s.isNumber(strs[i]));
	}

}
