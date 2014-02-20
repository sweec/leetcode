package BestTimeToBuyAndSellStock;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testMaxProfit() {
		Solution s = new Solution();
		int[][] prices = {{4, 3, 2, 5, 1, 7}, {2, 1}, {1, 2}, {1, 2, 4}, {4, 3, 1, 5, 2, 7}};
		int[] max = {6, 0, 1, 3, 6};
		for (int i=0;i<prices.length;i++)
			assertEquals("Max profit is wrong", max[i], s.maxProfit(prices[i]));
	}

}
