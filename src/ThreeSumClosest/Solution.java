package ThreeSumClosest;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] num, int target) {
        if (num == null || num.length < 1)
            return 0;
        int len = num.length;
        if (len == 1)
        	return num[0];
        if (len == 2)
        	return num[0]+num[1];
        Arrays.sort(num);
        int sum1 = num[0]+num[1]+num[2];
        int sum2 = num[len-1]+num[len-2]+num[len-3];
        if (sum1 >= target)
        	return sum1;
        if (sum2 <= target)
            return sum2;
        int closest = sum1, d = target - sum1;
        if (sum2-target < target-sum1) {
        	closest = sum2;
        	d = sum2 - target;
        }
        for (int i = 0;i < len-2;i++) {
        	int s1 = num[i]+num[i+1]+num[i+2];
        	if (s1 > target) {
        		if (s1 - target < d) {
        			closest = s1;
        			d = s1 - target;
        		}
        		break;
        	}
        	int s2 = num[i]+num[len-2]+num[len-1];
        	if (s2 < target) {
        		if (target - s2 < d) {
        			closest = s2;
        			d = target - s2;
        		}
        		continue;
        	}
        	for (int j = i+1;j < len-1;j++) {
        		s1 = num[i]+num[j]+num[j+1];
            	if (s1 > target) {
            		if (s1 - target < d) {
            			closest = s1;
            			d = s1 - target;
            		}
            		break;
            	}
            	s2 = num[i]+num[j]+num[len-1];
            	if (s2 < target) {
            		if (target - s2 < d) {
            			closest = s2;
            			d = target - s2;
            		}
            		continue;
            	}
            	int k = j+1; s1 = num[i] + num[j];
            	while (k < len-1 && s1+num[k] < target)
            		k++;
            	int dk = Math.abs(s1+num[k] - target);
            	if (dk < d) {
            		closest = s1+num[k];
            		d = dk;
            	}
            	if (s1+num[k] >= target) {
            		dk = target - s1 - num[k-1];
                	if (dk < d) {
                		closest = s1+num[k-1];
                		d = dk;
                	}
            	}
        	}
        }
        return closest;
    }
    
 }
