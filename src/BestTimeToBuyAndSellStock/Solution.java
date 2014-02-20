package BestTimeToBuyAndSellStock;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
        	return 0;
        int len = prices.length-1;
        int[] diffs = new int[len];
        for (int i=0;i<len;i++)
        	diffs[i] = prices[i+1] - prices[i];
        int max = 0, sum = 0;
        for (int i=0;i<len;i++) {
        	int next = sum + diffs[i];
        	if (next < sum) {
        		if (max < sum)
        			max = sum;
        		if (next < 0)
        			sum = 0;
        		else
        			sum = next;
        	} else
        		sum = next;
        }
        if (max < sum)
        	max = sum;
        return max;
    }
}
