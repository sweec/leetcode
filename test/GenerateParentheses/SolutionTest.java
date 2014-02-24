package GenerateParentheses;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testGenerateParenthesis() {
		Solution s = new Solution();
		String[] answer = {"()()()", "(())()", "()(())", "(()())", "((()))"};
		ArrayList<String> ps = s.generateParenthesis(3);
		for (int i=0;i<ps.size();i++)
			assertEquals((i+1)+"th permutation not agree", answer[i], ps.get(i));
	}

}
