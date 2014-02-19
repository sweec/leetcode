package ValidParentheses;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testIsValid() {
		Solution s = new Solution();
		String[] strs = {"()", "()[]{}", "(]", "([)]"};
		boolean[] valid = {true, true, false, false};
		for (int i=0;i<strs.length;i++)
			assertEquals("Validaty of "+strs[i]+" is wrong", valid[i], s.isValid(strs[i]));
	}

}
