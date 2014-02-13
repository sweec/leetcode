package Candy;

public class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length < 1)
            return 0;
        int n = ratings.length;
        int sum = 0, candy = 1;
        int index1 = 0;
        while (index1 < n-1) {
        	int cr = ratings[index1], nr = ratings[index1+1];
        	if (nr == cr) {
        		sum += candy;
        		candy = 1;
        		index1++;
        	} else if (nr > cr) {
        		sum += candy;
        		candy++;
        		index1++;
        	} else {
        		int index2 = index1+1;
        		while (index2 < n-1) {
        			if (ratings[index2+1] >= ratings[index2])
        				break;
        			index2++;
        		}
        		int candy2 = 1;
        		for (int i = index2-1;i > index1;i--) {
        			candy2++;
        			sum += candy2;
        		}
        		sum += Math.max(candy, candy2+1);
        		if (index2 == n-1)
        			return sum+1;
        		index1 = index2;
        		candy = 1;
        	}
        }
        return sum+candy;
    }
}
