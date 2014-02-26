package PalindromeNumber;

public class Solution {
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		long copy = x;
		long y = 0;
		while (x > 0) {
			y = y*10+(x%10);
			x /= 10;
		}
		if (y == copy)
			return true;
		return false;
	}
}
