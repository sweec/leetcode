package MergeSortedArray;

public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        if (A == null || B == null || A.length < m+n || B.length < n)
        	return;
        if (m < 0 || n < 1)
        	return;
        for (int i=m-1;i>=0;i--)
        	A[n+i] = A[i];
        int i = n, j = 0, k = 0;
        while (i < m+n && j < n) {
        	int a = A[i], b = B[j];
        	if (a <= b) {
        		A[k++] = a;
        		i++;
        	} else {
        		A[k++] = b;
        		j++;
        	}
        }
        for (;j<n;j++)
        	A[k++] = B[j];
    }
}
