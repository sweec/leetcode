package ReverseWordsInAString;

public class Solution {
    public String reverseWords(String s) {
        StringBuffer sentence = new StringBuffer();
        StringBuffer sb = new StringBuffer();
        for (int i=s.length()-1;i>=0;i--) {
        	char c = s.charAt(i);
        	if (Character.isWhitespace(c)) {
        		if (sb.length() > 0) {
        			sentence.append(sb.reverse()+" ");
        			sb.setLength(0);;
        		}
        	} else
        		sb.append(c);
        }
        if (sb.length() > 0)
        	sentence.append(sb.reverse());
        int len = sentence.length();
        if (len>0 && sentence.charAt(len-1) == ' ')
        	sentence.setLength(len-1);
        return sentence.toString();
    }
}