package LargestRectangleInHistogram;

public class Solution {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length < 1)
        	return 0;
        int max = 0;
        int i = 0;
        while (i<height.length) {
        	if (height[i] > 0) {
        		while (i<height.length-1 && height[i+1] >= height[i])
        			i++;
        		int h = height[i];
        		for (int j=i;j>=0;j--) {
        			if (height[j] == 0)
        				break;
        			h = Math.min(h, height[j]);
        			if ((long)h*(long)(i+1) <= max)
        				break;
        			max = Math.max(max, h*(i+1-j));
        		}
        	}
    		i++;
        }
        return max;
    }
}
