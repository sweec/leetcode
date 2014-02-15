package ImplementStrStr;

import java.util.ArrayList;

public class Solution {
    public String strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length())
        	return null;
        if (needle.isEmpty())
        	return haystack;
        
        int len1 = haystack.length(), len2 = needle.length();
		// get info of char repeats in needle
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        char last = needle.charAt(0);
        for (int i=1;i<len2;i++) {
        	char c = needle.charAt(i);
        	if (c != last) {
        		indexes.add(i);
        		last = c;
        	}
        }
        indexes.add(len2);
		
        // now go for strStr
        char c0 = needle.charAt(0);
        int count0 = indexes.get(0);
        int offset = 0;
		do {
			// match 1st char
			int index = offset;
			while (index <= Math.min(len1-len2+count0, len1-1)) {
				char c = haystack.charAt(index);
				if (c != c0) {
					if (index-offset < count0)
						offset = index+1;
					else
						break;
				}
				index++;
				// only 1 char in needle?
				if (count0 == len2 && index-offset>=count0)
				    return haystack.substring(offset);
			}
			if (index > len1-len2+count0)
				break;
			if (index-offset < count0)
				break;
			offset = index - count0;
			
			// now match other chars
			int pre = count0, cur = 0, count = 0;
			int i=1;
			for (;i<indexes.size();i++) {
				char ci = needle.charAt(pre);
				cur = indexes.get(i);
				count = 0;
				while (index < len1) {
					char c = haystack.charAt(index);
					if (c != ci)
						break;
					index++;
					count++;
					if (i == indexes.size()-1 && count == cur-pre)
						break;
					if (count > cur-pre)
						break;
				}
				if (count != cur-pre)
					break;
				pre = cur;
			}
			if (i >= indexes.size()-1 && index-offset == len2)
				return haystack.substring(offset);
			offset += count0+1;
		} while (true);
		return null;
    }
}
