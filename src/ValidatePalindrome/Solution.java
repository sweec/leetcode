package ValidatePalindrome;

public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() < 2)
        	return true;
        char[] chs = s.toCharArray();
        int len = chs.length;
        int l = 0, r = len - 1;
        while (r > l) {
        	int lv = -1, rv = -1;
        	while (l < r) {
        		char c = chs[l];
        		if (c >= 'a' && c <= 'z') {
        			lv = c - 'a';
        			break;
        		}
        		if (c >= 'A' && c <= 'Z') {
        			lv = c - 'A';
        			break;
        		}
        		if (c >= '0' && c <= '9'){
        			lv = c - '0' + 26;
        			break;
        		}
        		l++;
        	}
        	while (l < r) {
        		char c = chs[r];
        		if (c >= 'a' && c <= 'z') {
        			rv = c - 'a';
        			break;
        		}
        		if (c >= 'A' && c <= 'Z') {
        			rv = c - 'A';
        			break;
        		}
        		if (c >= '0' && c <= '9'){
        			rv = c - '0' + 26;
        			break;
        		}
        		r--;
        	}
        	if (lv >=0 && rv >= 0 && lv != rv)
        		return false;
        	l++;
        	r--;
        }
        return true;
    }
}
