package PermutationSequence;

public class Solution {
    public String getPermutation(int n, int k) {
    	if (n < 1)
    		return "";
        char[] permutation = new char[n];
        int[] permutationNum = new int[n];
        for (int i = 0;i < n;i++) {
        	permutation[i] = (char)(((int)'1')+i);
        	permutationNum[i] = (i>0)?permutationNum[i-1]*(i+1):1;
        }
        if (k > permutationNum[n-1])
        	return "";
        do {
        	int i = 0;
        	while (i < n && k >= permutationNum[i])
        		i++;
        	i--;
        	int d = (k+permutationNum[i]-1) / permutationNum[i] - 1;
        	if (d > 0) {
        		char temp = permutation[n-i-2+d];
        		for (int j = d;j > 0;j--)
        			permutation[n-i-2+j] = permutation[n-i-2+j-1];
        		permutation[n-i-2] = temp;
	        }
        	k %= permutationNum[i];
        	if (k == 1)
        		break;
        	if (k == 0) {
        		int len = n;
        		for (int j = n-i-1;j < len;j++) {
        			char temp = permutation[j];
        			permutation[j] = permutation[len-1];
        			permutation[len-1] = temp;
        			len--;
        		}
        		break;
        	}
        } while (true);
        return new String(permutation);
    }
}
