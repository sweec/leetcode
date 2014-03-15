package RestoreIPAddresses;

import java.util.ArrayList;

public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
    	ArrayList<String> ips = new ArrayList<String>();
        if (s == null)
        	return ips;
        restoreIpAddresses(s, 0, 4, ips);
        return ips;
    }
    
    private void restoreIpAddresses(String s, int beg, int num, ArrayList<String> ips) {
        int len = s.length()-beg;
        if (len < num || len > 3*num)
        	return;
        if (num == 0) {
        	ips.add("");
        	return;
        }
        int min = Math.max(1, len-3*(num-1));
    	int max = Math.min(3, len-(num-1));
    	int val = 0;
    	for (int i=1;i<=max;i++) {
    		char c = s.charAt(beg+i-1);
    		val = val*10 + (c-'0');
    		if (i >= min && val < 256) {
    			int size = ips.size();
    			restoreIpAddresses(s, beg+i, num-1, ips);
    			if (ips.size() > size) {
    				String str = s.substring(beg, beg+i);
    				if (num > 1)
    					str += ".";
    				for (int j=size;j<ips.size();j++)
    					ips.set(j, str+ips.get(j));
    			}
    		}
    		if (val == 0)
    			break;
    	}
    }
}
