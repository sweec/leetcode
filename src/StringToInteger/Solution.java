package StringToInteger;

public class Solution {
    public int atoi(String str) {
        if (str == null || str.isEmpty())
        	return 0;
        int len = str.length();
        int index = 0;
        while (index < len) {
        	if (!Character.isWhitespace(str.charAt(index)))
        		break;
        	index++;
        }
        if (index == len)
        	return 0;
        char c = str.charAt(index);
        if (c != '+' && c != '-' && !(c >= '0' && c <= '9'))
        	return 0;
        int sign = 1;
        if (c == '-')
        	sign = -1;
        if (c == '+' || c == '-') {
        	index++;
        	if (index == len)
        		return 0;
        	c = str.charAt(index);
        	if (!(c >= '0' && c <= '9'))
        		return 0;
        }
        long i = c - '0';
        index++;
        while (index < len) {
        	c = str.charAt(index);
        	if (!(c >= '0' && c <= '9'))
        		break;
        	i = (i << 3) + (i << 1) + (c - '0');
        	index++;
        }
        i *= sign;
        if (i > Integer.MAX_VALUE)
        	return Integer.MAX_VALUE;
        if (i < Integer.MIN_VALUE)
        	return Integer.MIN_VALUE;
        return (int) i;
    }
}
