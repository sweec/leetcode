package AddBinary;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testAddBinary() {
		Solution s = new Solution();
		String a = "11", b = "101";
		assertEquals("Summation of "+a+" and "+b+" is not correct.", "1000", s.addBinary(a, b));
	}

}
