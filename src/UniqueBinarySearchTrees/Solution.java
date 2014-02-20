package UniqueBinarySearchTrees;

public class Solution {
    public int numTrees(int n) {
        if (n <= 0)
        	return 0;
        int[] nums = new int[n+1];
        nums[0] = 1;
        nums[1] = 1;
        for (int i=2;i<=n;i++) {
        	for (int j=1;j<=i/2;j++)
        		nums[i] += nums[j-1]*nums[i-j];
        	nums[i] <<= 1;
        	if (i % 2 == 1)
        		nums[i] += nums[i/2]*nums[i/2];
        }
        return nums[n];
    }
}
