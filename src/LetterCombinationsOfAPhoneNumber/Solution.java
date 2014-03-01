package LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;

public class Solution {
	private char[][] map = {{' '}, {' '}, {'a', 'b', 'c'}, {'d', 'e', 'f'},
			{'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
			{'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
	
    public ArrayList<String> letterCombinations(String digits) {
    	ArrayList<String> combs = new ArrayList<String>();
    	if (digits == null) {
    		combs.add(null);
    		return combs;
    	}
    	if (!digits.isEmpty()) {
        	int len = digits.length();
        	ArrayList<StringBuffer> sbs = new ArrayList<StringBuffer>();
        	letterCombinations(digits, len, sbs);
        	for (StringBuffer sb:sbs)
        		combs.add(sb.toString());
    	}
    	if (combs.isEmpty())
    		combs.add("");
    	return combs;
    }
    
    private void letterCombinations(String digits, int end, ArrayList<StringBuffer> sbs) {
    	int index = end - 1;
    	char c = '1';
    	while (index >= 0) {
    		c = digits.charAt(index);
    		if (Character.isDigit(c) && c != '1')
    			break;
       		index--;
    	}
     	if (index < 0)
    		return;
    	letterCombinations(digits, index, sbs);
    	if (sbs.isEmpty()) {
    		StringBuffer sb = new StringBuffer();
    		sb.append("");
    		sbs.add(sb);
    	}
    	int size = sbs.size();
    	index = c-'0';
    	for (int i=0;i<size;i++) {
    		StringBuffer sb = sbs.get(i);
    		for (int j=1;j<map[index].length;j++) {
    			StringBuffer cur = new StringBuffer(sb);
    			cur.append(map[index][j]);
    			sbs.add(cur);
    		}
    		sb.append(map[index][0]);
    	}
    }
}
