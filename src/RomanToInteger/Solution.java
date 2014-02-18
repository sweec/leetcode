package RomanToInteger;

public class Solution {
    public int romanToInt(String s) {
    	if (s == null || s.length() < 1)
    		return 0;
        char[] RomansI = {'M', 'C', 'X', 'I'};
        char[] RomansV = {'N', 'D', 'L', 'V'};
        int[] factors = {1000, 100, 10, 1};
        int num = 0;
        int index = 0, len = s.length();
        char c = s.charAt(index);
        for (int i = 0;i < 4;i++) {
        	if (c == RomansI[i]) {
            	index++;
        		if (index == len) {
        			num += factors[i];
        		} else {
        			c = s.charAt(index);
        			if (c == RomansI[i]) {
        				num += factors[i] << 1;
        				index++;
        				if (index < len) {
        					c = s.charAt(index);
        					if (c == RomansI[i]) {
        						num += factors[i];
        						index++;
        					} else
        						continue;
        				}
        			} else if (c == RomansV[i]) {
        				num += factors[i] << 2;
        				index++;
        			} else if (i > 0 && c == RomansI[i-1]) {
        				num += factors[i-1] - factors[i];
        				index++;
        			} else {
        				num += factors[i];
        				continue;
        			}
        		}
        	} else if (c == RomansV[i]) {
            	index++;
        		num += (factors[i] << 2) + factors[i];
        		while (index < len) {
        			c = s.charAt(index);
        			if (c != RomansI[i])
        				break;
        			num += factors[i];
        			index++;
        		}
        		continue;
        	}
        	if (index >= len)
        		break;
        	c = s.charAt(index);
        }
        return num;
    }
}
