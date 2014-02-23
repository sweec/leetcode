package ContainerWithMostWater;

public class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2)
        	return 0;
        int a = 0, b = height.length - 1;
        int max = Math.min(height[a], height[b]) * (b - a);
        do {
        	if (height[a] <= height[b]) {
        		int old = height[a];
        		a++;
        		while (a < b && height[a] <= old)
        			a++;
        		if (a >= b)
        			break;
        		int sum = Math.min(height[a], height[b]) * (b - a);
        		if (max < sum)
        			max = sum;
        	} else {
        		int old = height[b];
        		b--;
        		while (a < b && height[b] <= old)
        			b--;
        		if (a >= b)
        			break;
        		int sum = Math.min(height[a], height[b]) * (b - a);
        		if (max < sum)
        			max = sum;
        	}
        } while (true);
        return max;
    }
}
