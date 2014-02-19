package LengthOfLastWord;

public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty())
        	return 0;
        int index1 = s.length()-1;
        while (index1 >= 0) {
        	if (s.charAt(index1) != ' ')
        		break;
        	index1--;
        }
        if (index1 < 0)
        	return 0;
        int index2 = index1 - 1;
        while (index2 >= 0) {
        	if (s.charAt(index2) == ' ')
        		break;
        	index2--;
        }
        return index1-index2;
    }
}
