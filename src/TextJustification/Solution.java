package TextJustification;

import java.util.ArrayList;

public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
    	ArrayList<String> text = new ArrayList<String>();
    	if (words == null || words.length < 1) {
    		text.add("");
    		return text;
    	}
    	int linelen = words[0].length(), linebeg = 0;
    	for (int i=1;i<words.length;i++) {
    		int newlen = linelen+words[i].length()+1;
    		if (newlen > L) {
    			StringBuffer sb = new StringBuffer();
				sb.append(words[linebeg]);
    			int num = i-linebeg;
    			if (num == 1)
    				addspace(sb, L-linelen);
    			else {
    				int padding = (L-linelen)/(num-1);
    				int extra = L-linelen - padding*(num-1);
    				for (int j=linebeg+1;j<=linebeg+extra;j++) {
    					addspace(sb, padding+2);
    					sb.append(words[j]);
    				}
    				for (int j=linebeg+extra+1;j<i;j++) {
       					addspace(sb, padding+1);
    					sb.append(words[j]);
    				}
    			}
				text.add(sb.toString());
				linebeg = i;
				linelen = words[i].length();
    		} else
    			linelen = newlen;
    	}
    	StringBuffer sb = new StringBuffer();
    	sb.append(words[linebeg]);
    	for (int i=linebeg+1;i<words.length;i++)
    		sb.append(" "+words[i]);
		addspace(sb, L-linelen);
    	text.add(sb.toString());
    	return text;
    }
    
    private void addspace(StringBuffer sb, int len) {
    	for (int i=0;i<len;i++)
    		sb.append(' ');
    }
}
