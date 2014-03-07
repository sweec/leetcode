package ZigZagConversion;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testConvert() {
		Solution s = new Solution();
		String str = "PAYPALISHIRING";
		int nRows = 3;
		String answer = "PAHNAPLSIIGYIR";
		assertEquals("Conversion not agree", answer, s.convert(str, nRows));
	}

}
