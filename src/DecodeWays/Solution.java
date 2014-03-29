package DecodeWays;

public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.isEmpty())
        	return 0;
        int len = s.length();
        int pred = s.charAt(0) - '0';
        if (pred == 0)
        	return 0;
        // let 0 and 1 digit have 1 way to decode
        int pre = 1, cur = 1;
        for (int i=1;i<len;i++) {
        	int curd = s.charAt(i) - '0';
        	int num = cur;
        	if (curd == 0) {
        		if (pred == 1 || pred == 2)
        			num = pre;
        		else
        			return 0;
        	} else if (pred>0 && pred*10+curd<27)
        		num += pre;
        	pre = cur;
        	cur = num;
        	pred = curd;
        }
        return cur;
    }
}
