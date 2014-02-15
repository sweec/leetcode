package StringToInteger;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testAtoi() {
		Solution s = new Solution();
	    String[] strs = {"\t42", "   3.14159", "\n31337 with words", "words and 2", "-4", "+0"};
	    int[] val = {42, 3, 31337, 0, -4, 0};
	    for (int i=0;i<strs.length;i++)
	    	assertEquals(strs[i]+" return a wrong integer value", val[i], s.atoi(strs[i]));
	}

}
