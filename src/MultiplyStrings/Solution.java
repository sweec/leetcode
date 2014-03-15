package MultiplyStrings;

public class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null)
        	return null;
        if (num1.isEmpty() || num2.isEmpty())
        	return "";
        int len1 = num1.length(), len2 = num2.length();
        int beg1 = 0, beg2 = 0;
        while (beg1 < len1 && num1.charAt(beg1) == '0')
        	beg1++;
        if (beg1 == len1)
        	return "0";
        while (beg2 < len2 && num2.charAt(beg2) == '0')
        	beg2++;
        if (beg2 == len2)
        	return "0";
        StringBuffer result = multiply(num1, beg1, len1, num2, beg2, len2);
        return result.toString();
    }
    
    private StringBuffer multiply(String num1, int beg1, int end1,
    		String num2, int beg2, int end2) {
    	int len1 = end1 - beg1, len2 = end2 - beg2;
    	if (len1+len2 < 10) {
    		int n1 = Integer.parseInt(num1.substring(beg1, end1));
    		int n2 = Integer.parseInt(num2.substring(beg2, end2));
    		StringBuffer sb = new StringBuffer();
    		sb.append(n1*n2);
    		return sb;
    	}
    	int tailZero = 0;
    	while (end1 > (beg1+1) && num1.charAt(end1-1) == '0') {
    		tailZero++;
    		end1--;
    	}
    	while (end2 > (beg2+1) && num2.charAt(end2-1) == '0') {
    		tailZero++;
    		end2--;
    	}
    	if (tailZero > 0) {
    		StringBuffer sb = multiply(num1, beg1, end1, num2, beg2, end2);
    		for (int i=0;i<tailZero;i++)
    			sb.append('0');
    		return sb;
    	}
    	StringBuffer sb1 = null, sb2 = null;
    	if (len1 > 4) {
    		sb1 = multiply(num1, beg1, end1-4, num2, beg2, end2);
    		sb2 = multiply(num1, end1-4, end1, num2, beg2, end2);
    	} else {
    		sb1 = multiply(num2, beg2, end2-4, num1, beg1, end1);
    		sb2 = multiply(num2, end2-4, end2, num1, beg1, end1);
    	}
    	sb1.append("0000");
    	len1 = sb1.length(); len2 = sb2.length();
    	int up = 0;
    	for (int i=1;i<=len2;i++) {
    		int sum = (sb1.charAt(len1-i)-'0') + (sb2.charAt(len2-i)-'0') + up;
    		if (sum > 9) {
    			sum -= 10;
    			up = 1;
    		} else
    			up = 0;
    		sb1.setCharAt(len1-i, (char) ('0'+sum));
    	}
		if (up == 0)
			return sb1;
    	for (int i=len2+1;i<=len1;i++) {
    		int sum = (sb1.charAt(len1-i)-'0') + up;
    		if (sum > 9) {
    			sum -= 10;
    			up = 1;
    		} else
    			up = 0;
    		sb1.setCharAt(len1-i, (char) ('0'+sum));
    		if (up == 0)
    			return sb1;
    	}
    	StringBuffer sb = new StringBuffer("1");
    	sb.append(sb1);
    	return sb;
    }
}
