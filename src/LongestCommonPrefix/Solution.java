package LongestCommonPrefix;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null)
            return null;
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        int n = 0;
        do {
            char c = '0';
            for (int i=0;i<strs.length;i++) {
                if (strs[i] == null)
                    return null;
                if (strs[i].length() <= n)
                    return strs[i].substring(0, n);
                if (i == 0)
                    c = strs[0].charAt(n);
                else if (strs[i].charAt(n) != c)
                    return strs[i].substring(0, n);
            }
            n++;
        } while (true);
    }
}
