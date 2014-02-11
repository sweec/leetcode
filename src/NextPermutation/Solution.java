package NextPermutation;

public class Solution {
    public void nextPermutation(int[] num) {
        if (num == null || num.length < 2)
        	return;
        int len = num.length;
        int index = len - 1;
        // find 1st element not in descending order reversely
        while (index > 0 && num[index] <= num[index-1])
        	index--;
        // exchange the found element with the closest larger one
        if (index > 0) {
        	int temp = num[index-1];
        	int i = index + 1;
        	while (i < len && num[i] > temp)
        		i++;
        	i--;
        	num[index-1] = num[i];
        	num[i] = temp;
        }
        // reverse descending to ascending
        for (int i = index; i < len; i++) {
        	int temp = num[i];
        	num[i] = num[len-1];
        	num[len-1] = temp;
        	len--;
        }
    }
 }
