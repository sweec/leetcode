package HappyNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Solution {
	private static HashSet<Integer> happySet = null;
	private static Integer[] happyNums = {1,7,10,13,19,23,28,31,32,44,49,68,70,79,82,86,91,94,97,100,103,109,129,130,133,139,167,176,188,190,192,193};
	
    public boolean isHappy(int n) {
        if (n <= 0) return false;
        // method 1, iterate until reach 1 or loops, 217ms
        /*
        HashSet<Integer> set = new HashSet<Integer>();
        while (n != 1) {
        	int next = 0;
        	while (n > 0) {
        		int last = n % 10;
        		next += last*last;
        		n /= 10;
        	}
        	n = next;
        	if (set.contains(n))
        		return false;
        	else
        		set.add(n);
        }
        return true;
        */
        // method 2, provide known happy numbers <= 200 for fast lookup, 233ms
        // as all numbers will eventually drop to this range
        if (happySet == null)
        	happySet = new HashSet<Integer>(Arrays.asList(happyNums));
        while (n > 200) {
        	int next = 0;
        	while (n > 0) {
        		int last = n % 10;
        		next += last*last;
        		n /= 10;
        	}
        	n = next;
        }
        return happySet.contains(n);
    }
    
    public static void main(String[] argvs) {
		Solution s = new Solution();
		ArrayList<Integer> happyNumbers = new ArrayList<Integer>();
		for (int i=1;i<1000;i++)
			if (s.isHappy(i)) happyNumbers.add(i);
		System.out.println(happyNumbers.size()+" happy numbers: ");
		for (int i:happyNumbers)
			System.out.print(i+",");
    }
}
