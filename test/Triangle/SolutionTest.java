package Triangle;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

public class SolutionTest {

	@Test
	public void testMinimumTotal() {
		Solution s = new Solution();
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> num = new ArrayList<Integer>();
		num.add(2);
		triangle.add(num);
		num = new ArrayList<Integer>();
		num.add(3); num.add(4);
		triangle.add(num);
		num = new ArrayList<Integer>();
		num.add(6); num.add(5); num.add(7);
		triangle.add(num);
		num = new ArrayList<Integer>();
		num.add(4); num.add(1); num.add(8); num.add(3);
		triangle.add(num);
		assertEquals("Minimum total is wrong", 11, s.minimumTotal(triangle));
	}

}
