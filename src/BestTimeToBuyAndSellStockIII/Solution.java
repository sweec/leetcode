package BestTimeToBuyAndSellStockIII;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
        	return 0;
        int len = prices.length;
        // get max transaction and premax, the one before it
        int max = 0, sum = 0, beg = 0, end = 1, offset = 0;
        int preMax = 0;
        for (int i=1;i<len;i++) {
        	int diff = prices[i] - prices[i-1];
        	if (diff < 0) {
        		if (max < sum) {
        			if (end <= offset)
        				preMax = max;
        			max = sum;
        			beg = offset;
        			end = i;
        		}
        		if (sum+diff < 0)
        			sum = 0;
        		else
        			sum += diff;
        	} else {
        		if (sum == 0)
        			offset = i-1;
        		sum += diff;
        	}
        }
        if (max < sum) {
			if (end <= offset)
				preMax = max;
        	max = sum;
        	beg = offset;
        	end = len;
        }
        // check if max transaction can be divided into two to get more profit
        // if yes, max - lost is the better profit
        int lost = 0; sum = 0;
        for (int i=beg+1;i<end;i++) {
        	int diff = prices[i] - prices[i-1];
        	if (diff <= 0)
        		sum += diff;
        	else {
        		if (lost > sum)
        			lost = sum;
        		sum = 0;
        	}
        }
        // get postmax, the one after max transaction
        int postMax = 0; sum = 0;
        for (int i=end;i<len;i++) {
        	int diff = prices[i] - prices[i-1];
        	if (diff < 0) {
        		if (postMax < sum)
        			postMax = sum;
        		if (sum+diff < 0)
        			sum = 0;
        		else
        			sum += diff;
        	} else
        		sum += diff;
        }
        if (postMax < sum)
        	postMax = sum;
        
        return max+Math.max(-lost, Math.max(preMax, postMax));
    }
}
