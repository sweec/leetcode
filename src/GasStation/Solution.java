package GasStation;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length < 1)
            return 0;
        int n = gas.length;
        int sum = 0, index = 0, total = 0;
        for (int i=0;i<n;i++) {
            sum += gas[i] - cost[i];
            if (sum < 0) {
                total += sum;
                sum = 0;
                index = i+1;
            }
        }
        total += sum;
        if (total < 0)
            return -1;
        else
            return index;
    }
}
