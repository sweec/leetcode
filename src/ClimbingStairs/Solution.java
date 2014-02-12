package ClimbingStairs;

public class Solution {
    public int climbStairs(int n) {
        if (n < 2)
            return 1;
        int c0 = 1, c1 = 1;
        for (int i=2;i<=n;i++) {
            int temp = c1;
            c1 = c0 + c1;
            c0 = temp;
        }
        return c1;
    }
}
