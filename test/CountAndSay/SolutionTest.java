package CountAndSay;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testCountAndSay() {
		Solution s = new Solution();
		String[] cas = {"1", "11", "21", "1211", "111221", "312211"};
		for (int i=0;i<cas.length;i++)
			assertEquals("Count and Say "+(i+1)+"th value not correct", cas[i], s.countAndSay(i+1));
	}

}
