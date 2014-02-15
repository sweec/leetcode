package AddBinary;

public class Solution {
    public String addBinary(String a, String b) {
        if (a == null || a.isEmpty())
        	return b;
        if (b == null || b.isEmpty())
        	return a;
        if (a.length() < b.length()) {
        	String temp = a;
        	a = b;
        	b = temp;
        }
        int len1 = a.length(), len2 = b.length();
        StringBuffer sb = new StringBuffer();
        int extra = 0;
        for (int i = 1;i <= len2;i++) {
        	int bit = (a.charAt(len1-i)-'0') + (b.charAt(len2-i)-'0') + extra;
         	sb.append((char)('0'+(bit&1)));
        	extra = bit >>> 1;
        }
        for (int i = len1-len2-1;i >= 0;i--) {
        	if (extra == 0) {
        		for (int j = i;j >= 0;j--)
        			sb.append(a.charAt(j));
        		break;
        	}
        	int bit = a.charAt(i)-'0' + extra;
         	sb.append((char)('0'+(bit&1)));
        	extra = bit >>> 1;
        }
        if (extra == 1)
         	sb.append('1');
        // now reverse the bits
        sb.reverse();
        return sb.toString();
    }
}
