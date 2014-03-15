package InsertInterval;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import InsertInterval.Solution.Interval;

public class SolutionTest {

	@Test
	public void testInsert() {
		Solution s = new Solution();
		//int[][] input = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
		//int[][] output = {{1, 2}, {3, 10}, {12, 16}};
		int[][] input = {{1, 3}, {6, 9}};
		int[][] output = {{1, 5}, {6, 9}};
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		ArrayList<Interval> ans = new ArrayList<Interval>();
		for (int i=0;i<input.length;i++)
			intervals.add(s.new Interval(input[i][0], input[i][1]));
		for (int i=0;i<output.length;i++)
			ans.add(s.new Interval(output[i][0], output[i][1]));
		//ArrayList<Interval> mis = s.insert(intervals, s.new Interval(4, 9));
		ArrayList<Interval> mis = s.insert(intervals, s.new Interval(2, 5));
		assertEquals("Merge size not agree", ans.size(), mis.size());
		for (int i=0;i<ans.size();i++) {
			assertEquals("start not agree", ans.get(i).start, mis.get(i).start);
			assertEquals("end not agree", ans.get(i).end, mis.get(i).end);
		}
	}

}
