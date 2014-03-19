package EvaluateReversePolishNotation;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testEvalRPN() {
		Solution s = new Solution();
		String[][] tokens = {{"2", "1", "+", "3", "*"}, {"4", "13", "5", "/", "+"}};
		int[] ans = {9, 6};
		for (int i=0;i<tokens.length;i++)
			assertEquals("Evaluate to wrong value", ans[i], s.evalRPN(tokens[i]));
	}

}
