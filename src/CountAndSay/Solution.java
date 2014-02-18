package CountAndSay;

public class Solution {
    public String countAndSay(int n) {
    	if (n < 1)
    		return "";
    	if (n == 1)
    		return "1";
    	String pre = countAndSay(n-1);
    	StringBuffer sb = new StringBuffer();
    	int index = 1, len = pre.length();
    	char last = pre.charAt(0);
    	int count = 1;
    	while (index < len) {
    		char c = pre.charAt(index);
    		if (c != last) {
    			sb.append(count);
    			sb.append(last);
    			last = c;
    			count = 1;
    		} else {
    			count++;
    		}
    		index++;
    	}
    	sb.append(count);
    	sb.append(last);
    	return sb.toString();
    }
}
