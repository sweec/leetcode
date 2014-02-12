package GrayCode;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> gc = new ArrayList<Integer>();
        gc.add(0);
        int d = 1;
        for (int i=1;i<=n;i++) {
            int len = gc.size();
            for (int j=len-1;j>=0;j--)
                gc.add(d+gc.get(j));
            d += d;
        }
        return gc;
    }
}
