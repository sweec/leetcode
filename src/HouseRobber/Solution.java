package HouseRobber;

public class Solution {
    public int rob(int[] num) {
        if (num == null || num.length == 0) return 0;
        int[] maxrob = new int[num.length];
        // method 1 recursive, 195ms
        /*
        for (int i=0;i<num.length;i++) maxrob[i] = -1;
        return rob(num, 0, maxrob);*/
        
        // method 2 non-recursive, 218ms
        if (num.length == 1) return num[0];
        maxrob[0] = num[0];
        maxrob[1] = Math.max(num[0], num[1]);
        for (int i=2;i<num.length;i++)
            maxrob[i] = Math.max(maxrob[i-2]+num[i], maxrob[i-1]);
        return maxrob[num.length-1];
    }
    // method 1 function
    /*
    public int rob(int[] num, int index, int[] maxrob) {
        int rob1 = 0, rob2 = 0;
        if (index+1 < num.length) {
            if (maxrob[index+1] >= 0)
                rob1 = maxrob[index+1];
            else
                rob1 = rob(num, index+1, maxrob);
        }
        if (index+2 < num.length) {
            if (maxrob[index+2] >= 0)
                rob2 = maxrob[index+2];
            else
                rob2 = rob(num, index+2, maxrob);
        }
        maxrob[index] = Math.max(num[index]+rob2, rob1);
        return maxrob[index];
    }*/
}