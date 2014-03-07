package ZigZagConversion;

public class Solution {
    public String convert(String s, int nRows) {
        if (s == null || s.length() < 3 || nRows < 2)
        	return s;
        int len = s.length();
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<len;i+=nRows+nRows-2)
        	sb.append(s.charAt(i));
        for (int row=1;row<nRows-1;row++)
            for (int i=row;i<len;i+=nRows+nRows-2) {
            	sb.append(s.charAt(i));
            	int next = i+nRows+nRows-2-row-row;
            	if (next < len)
            		sb.append(s.charAt(next));
            }
        for (int i=nRows-1;i<len;i+=nRows+nRows-2)
        	sb.append(s.charAt(i));
        return sb.toString();
    }
}
