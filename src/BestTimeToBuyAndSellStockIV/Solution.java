package BestTimeToBuyAndSellStockIV;

import java.util.ArrayList;

public class Solution {
    private class ListNode {
     	public ListNode prev;
        public ListNode next;
        public int index;
        public int buy;
        public int sell;
        public int lose;	// profit lose if this node is merged
        
        public ListNode() {};
    }
    
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length < 2 || k <= 0) return 0;
        int n = prices.length;

        // simplify prices to only low and max points
        int index = 0;
        int maxEarn = 0;
        // for method 1-3, 5
        
        ArrayList<Integer> ps = new ArrayList<Integer>();
        do {
            while (index<n-1 && prices[index+1]<=prices[index]) index++;
            if (index >= n-1) break;
            ps.add(prices[index]);
            maxEarn -= prices[index];
            index++;
            while (index<n-1 && prices[index+1]>=prices[index]) index++;
            ps.add(prices[index]);
            maxEarn += prices[index];
            index++;
        } while (index < n-1);
        n = ps.size();
        if (n == 0) return 0;
        if (k >= n/2)
            return maxEarn;
        
        
        // for method 4
        /*
        ListNode head = new ListNode(), prev = head;
        int m = 0;
        do {
            while (index<n-1 && prices[index+1]<=prices[index]) index++;
            if (index >= n-1) break;
            ListNode cur = new ListNode();
            cur.buy = prices[index];
            maxEarn -= prices[index];
            index++;
            while (index<n-1 && prices[index+1]>=prices[index]) index++;
            cur.sell = prices[index];
            maxEarn += prices[index];
            index++;
            prev.next = cur;
            prev = cur;
            m++;
        } while (index < n-1);
        if (m == 0) return 0;
        if (k >= m) return maxEarn;
		*/
        // method 1, DP, time limit exceeded, O(nkn/2)
        /*
        int[][] maxEarns = new int[n/2+1][k+1];
        for (int i=1;i<n;i=i+2) 
        for (int l=1;l<k+1;l++) {
            maxEarns[(i+1)/2][l] = maxEarns[(i-1)/2][l];
            for (int j=0;j<i;j=j+2)
                if (ps.get(i)>ps.get(j))
                    maxEarns[(i+1)/2][l] = Math.max(maxEarns[(i+1)/2][l], maxEarns[(j+1)/2][l-1]+ps.get(i)-ps.get(j));
        }
        return maxEarns[n/2][k];
        */
        
        // method 2, remove n/2-k transactions by iterate through ps each time, O((n/2-k)n/2), 259ms
        /*
        for (int i=0;i<n/2-k;i++) {
            int minEarn = Integer.MAX_VALUE;
            int prev = -1, prevIndex = -1;
            for (int j=0;j<n;j=j+2) {
                if (ps.get(j) < 0) continue;
                int earn = ps.get(j+1)-ps.get(j);
                if (prev>=0 && ps.get(j+1)>ps.get(prev+1))
                    earn = ps.get(prev+1)-ps.get(j);
                if (minEarn > earn) {
                    minEarn = earn;
                    index = j;
                    prevIndex = prev;
                }
                prev = j;
            }
            // remove minEarn transaction
            maxEarn -= minEarn;
            ps.set(index, -1);
            if (prevIndex>=0 && ps.get(index+1)>ps.get(prevIndex+1))
                ps.set(prevIndex+1, ps.get(index+1));
        }
        */
        
        // method 3, merge n/2-k transactions, O((n/2-k)n/2), 382ms
        /*
        maxEarn = 0;
        for (int i=0;i<2*k;i=i+2) maxEarn += ps.get(i+1) - ps.get(i);
        int index_k = 2*(k-1), index_cur = index_k+2;
        while (index_cur < n) {
            int prev = -1, index_prev = -1, index_min = -1, minEarn = Integer.MAX_VALUE;
            for (int i=0;i<=index_k;i=i+2) {
                if (ps.get(i) < 0) continue;
                int earn = ps.get(i+1) - ps.get(i);
                if (prev>=0 && ps.get(i+1)>ps.get(prev+1))
                    earn = ps.get(prev+1)-ps.get(i);
                if (minEarn > earn) {
                    minEarn = earn;
                    index_min = i;
                    index_prev = prev;
                }
                prev = i;
            }
            int index_next = -1, buy_next = Integer.MAX_VALUE, profit_next = 0;
            int i = index_cur;
            for (;i<n;i=i+2) {
                if (ps.get(i) >= buy_next)
                    ps.set(i, -1);
                else {  // update buy in price
                    buy_next = ps.get(i);
                    if (index_next>=0) ps.set(index_next, -1);
                    index_next = i;
                }
                int sell_next = ps.get(i+1);
                profit_next = Math.max(profit_next, sell_next - buy_next);
                if (profit_next > minEarn) {    // merge case 1
                    maxEarn = maxEarn - minEarn + profit_next;
                    ps.set(index_next+1, sell_next);
                    if (index_next != i) ps.set(i, -1);
                    ps.set(index_min, -1);
                    if (index_prev>=0 && ps.get(index_min+1)>ps.get(index_prev+1))
                        ps.set(index_prev+1, ps.get(index_min+1));
                    index_k = index_next;
                    break;
                } else if (sell_next > ps.get(index_k+1)) { // merge case 2
                    maxEarn = maxEarn - ps.get(index_k+1) + sell_next;
                    ps.set(index_k+1, sell_next);
                    ps.set(index_next, -1);
                    break;
                }
            }
            index_cur = i+2;
        }
        */
        
        // method 4, use list, 322ms
        /*
        for (;m>k;m--) {
            int minEarn = Integer.MAX_VALUE;
            prev = head;
            ListNode cur = head.next, node_min = cur, node_prev = prev;
            while (cur != null) {
                int earn = cur.sell-cur.buy;
                if (prev != head && cur.sell>prev.sell)
                    earn = prev.sell-cur.buy;
                if (minEarn > earn) {
                    minEarn = earn;
                    node_min = cur;
                    node_prev = prev;
                }
                prev = cur;
                cur = cur.next;
            }
            // remove minEarn transaction
            maxEarn -= minEarn;
            node_prev.next = node_min.next;
            if (node_prev != head && node_min.sell>node_prev.sell)
                node_prev.sell = node_min.sell;
        }
        */
        
        // method 5, use list and min heap, 341ms
        ListNode[] heap = new ListNode[n/2];
        // build heap
        ListNode prev = null;
        for (int i=0;i<n;i=i+2) {
        	ListNode cur = new ListNode();
        	cur.buy = ps.get(i);
        	cur.sell = ps.get(i+1);
        	cur.lose = cur.sell - cur.buy;
        	cur.prev = prev;
        	if (prev != null) {
        		prev.next = cur;
        		if (cur.sell>prev.sell)
        			cur.lose = prev.sell - cur.buy;
        	}
        	prev = cur;
        	int j = i/2;
        	cur.index = j;
        	heap[j] = cur;
        	while (j>0) {
        		int p = (j-1)/2;
        		if (heap[p].lose <= heap[j].lose) break;
        		ListNode temp = heap[j];
        		heap[j] = heap[p];
        		heap[j].index = j;
        		heap[p] = temp;
        		heap[p].index = p;
        		j = p;
        	}
        }

        // remove n/2-k nodes from heap
        for (int i=0;i<n/2-k;i++) {
        	int last = n/2-1-i;
        	maxEarn -= heap[0].lose;
        	if (last == k) break;
        	ListNode node = heap[0];
        	heap[0] = heap[last];
        	heap[0].index = 0;
        	heap[last] = null;
        	shiftdown(heap, 0, last);
        	// update prev and next node
        	prev = node.prev;
        	ListNode next = node.next;
        	if (prev != null) {
        		prev.next = next;
        		if (prev.sell < node.sell) {
        			prev.sell = node.sell;
        			prev.lose = prev.sell - prev.buy;
        			if (prev.prev!=null && prev.prev.sell<prev.sell)
        				prev.lose = prev.prev.sell - prev.buy;
        			shiftdown(heap, prev.index, last);
        		}
        	}
        	if (next != null) {
        		next.prev = prev;
        		next.lose = next.sell - next.buy;
        		if (prev!=null && prev.sell<next.sell)
            		next.lose = prev.sell - next.buy;
        		shiftdown(heap, next.index, last);
        	}
        }
        return maxEarn;
    }

    private void shiftdown(ListNode[] heap, int p, int size) {
    	int j = p*2+1;
		while (j<size) {
			if (j<size-1 && heap[j+1].lose<heap[j].lose)
				j = j+1;
			if (heap[j].lose>=heap[p].lose) break;
			ListNode temp = heap[j];
			heap[j] = heap[p];
			heap[j].index = j;
			heap[p] = temp;
			heap[p].index = p;
			p = j;
			j = p*2+1;
		}
    }
    
}