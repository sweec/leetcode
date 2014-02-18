package ValidNumber;

public class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.length() < 1)
        	return false;
        int len = s.length();
        int index = 0;
        while (index < len && Character.isWhitespace(s.charAt(index)))
        	index++;
        if (index == len)
        	return false;
        char c = s.charAt(index);
        if (c != '+' && c != '-' && c != '.' && !(c >= '0' && c <= '9'))
        	return false;
        boolean hasD = false, hasE = false, hasP = false;
        if (c == '.') {
        	if (index+1 >= len)
        		return false;
        	char next = s.charAt(index+1);
        	if (!(next >= '0' && next <= '9'))
        		return false;
        	hasD = true;
        }
        int indexE = -1, indexP = -1;
        for (index++;index < len;index++) {
        	c = s.charAt(index);
        	if (c == '.') {
        		if (hasD || hasE)
        			return false;
        		if (hasP && (index-indexP) != 4)
        			return false;
        		char pre = s.charAt(index-1);
            	if (!(pre >= '0' && pre <= '9')) {
                	if (index+1 >= len)
                		return false;
                	char next = s.charAt(index+1);
                	if (!(next >= '0' && next <= '9'))
                		return false;
            	}
        		hasD = true;
        	} else if (c == 'e' || c == 'E') {
        		if (hasE)
        			return false;
        		if (hasP && (index-indexP) != 4)
        			return false;
        		char pre = s.charAt(index-1);
            	if (pre != '.' && !(pre >= '0' && pre <= '9'))
            		return false;
        		hasE = true;
        		indexE = index;
        	} else if (c == ',') {
        		if (hasD || hasE)
        			return false;
        		if (hasP) {
        			if (index-indexP != 4)
        				return false;
        		} else {
            		char pre = s.charAt(index-1);
                	if (!(pre >= '0' && pre <= '9'))
            			return false;
            		hasP = true;
        		}
        		indexP = index;
        	} else if (Character.isWhitespace(c)) {
        		if (hasE && index == indexE+1)
        			return false;
        		if (hasP && (index-indexP) != 4)
        			return false;
            	for (index++;index < len;index++)
            		if (!Character.isWhitespace(s.charAt(index)))
            			return false;
            	return true;
        	} else if (c == '+' || c == '-') {
        		if (!hasE || index != indexE+1 || index+1 >= len)
        			return false;
        		char next = s.charAt(index+1);
            	if (!(next >= '0' && next <= '9'))
            		return false;
        	} else if (!(c >= '0' && c <= '9'))
        		return false;
        }
        if (hasP && (index-indexP) != 4)
        	return false;
		if (hasE && index == indexE+1)
			return false;
		return true;
    }
}
