package EditDistance;

public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null)
        	return 0;
        if (word1 == null || word1.isEmpty())
        	return word2.length();
        if (word2 == null || word2.isEmpty())
        	return word1.length();
        int len1 = word1.length(), len2 = word2.length();
        int[][] eds = new int[len1+1][len2+1];
        for (int i=0;i<=len1;i++)
        	eds[i][0] = i;
        for (int j=0;j<=len2;j++)
        	eds[0][j] = j;
        for (int i=1;i<=len1;i++)
        	for (int j=1;j<=len2;j++) {
        		if (word1.charAt(i-1) == word2.charAt(j-1))
        			eds[i][j] = eds[i-1][j-1];
        		else
        			eds[i][j] = 1 + Math.min(eds[i-1][j-1],
        					Math.min(eds[i-1][j], eds[i][j-1]));
        	}
        return eds[len1][len2];
    }
}
