package SimplifyPath;

import java.util.ArrayList;

public class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.isEmpty() || !path.startsWith("/"))
        	return path;
        StringBuffer sb = new StringBuffer();
        sb.append("/");
        int sbindex = 0;
        ArrayList<Integer> slashIndexes = new ArrayList<Integer>();
        slashIndexes.add(0);
        int index = 1, len = path.length();
        while (index < len) {
        	char c = path.charAt(index);
        	if (c == '/') {
        		index++;
        		continue;
        	}
        	if (c == '.') {
        		// case .
        		if (index == len-1)
        			break;
        		char next = path.charAt(index+1);
        		// case ./
        		if (next == '/') {
        			index += 2;
        			continue;
        		}
        		// case .. or ../
        		if (next == '.' && (index == len-2 || path.charAt(index+2) == '/')) {
        			int size = slashIndexes.size();
        			if (size > 1) {
        				slashIndexes.remove(--size);
        				sbindex = slashIndexes.get(size-1);
        				sb.setLength(sbindex+1);
        			}
        			index += 3;
        			continue;
        		}
        	}
        	// case normal directory
        	// return invalid path
        	if (c == '\0')
        		return path;
        	sb.append(c);
        	sbindex++;
        	index++;
        	while (index < len) {
        		c = path.charAt(index);
        		if (c == '\0')
        			return path;
        		sb.append(c);
        		sbindex++;
        		index++;
        		if (c == '/') {
        			slashIndexes.add(sbindex);
        			break;
        		}
        	}
        }
        if (sbindex > 0 && sb.charAt(sbindex) == '/')
        	sb.setLength(sbindex);
        return sb.toString();
    }
}
