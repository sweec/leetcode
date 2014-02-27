package Triangle;

import java.util.ArrayList;

public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty())
        	return 0;
        int n = triangle.size();
        int[] min = new int[n];
        for (int i=0;i<n;i++) {
        	ArrayList<Integer> num = triangle.get(i);
        	if (num == null || num.isEmpty())
        		break;
        	int pre = min[0];
        	min[0] += num.get(0);
        	for (int j=1;j<i;j++) {
        		int cur = min[j];
        		min[j] = Math.min(pre, cur) + num.get(j);
        		pre = cur;
        	}
        	min[i] = pre + num.get(i);
        }
        int minT = min[0];
        for (int i=1;i<n;i++)
        	if (minT > min[i])
        		minT = min[i];
        return minT;
    }
}
