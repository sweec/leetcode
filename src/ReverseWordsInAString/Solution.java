package ReverseWordsInAString;

public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.isEmpty())
        	return "";
        int len = s.length();
        int beg = 0, end = len-1;
        for (;beg<len;beg++)
        	if (!Character.isWhitespace(s.charAt(beg)))
        		break;
        if (beg == len)
        	return "";
        for (;end>=0;end--)
        	if (!Character.isWhitespace(s.charAt(end)))
        		break;
        StringBuffer sentence = new StringBuffer();
        StringBuffer sb = null;
        for (int i=end;i>=beg;i--) {
        	char c = s.charAt(i);
        	if (Character.isWhitespace(c)) {
        		if (sb != null) {
        			sentence.append(sb.reverse()+" ");
        			sb = null;
        		}
        	} else {
        		if (sb == null)
        			sb = new StringBuffer();
        		sb.append(c);
        	}
        }
        if (sb != null)
        	sentence.append(sb.reverse());
        return sentence.toString();
    }
}
