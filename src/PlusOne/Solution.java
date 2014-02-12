package PlusOne;

public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length < 1)
            return new int[]{1};
        int len = digits.length;
        for (int i=1;i<len+1;i++) {
            if (digits[len-i] < 9) {
                digits[len-i]++;
                return digits;
            } else
                digits[len-i] = 0;
        }
        int[] num = new int[len+1];
        num[0] = 1;
        return num;
    }
 }
