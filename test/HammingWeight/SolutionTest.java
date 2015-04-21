package HammingWeight;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testHammingWeight() {
		Solution s = new Solution();
		assertEquals("wrong answer", 3, s.hammingWeight(11));
	}

}
