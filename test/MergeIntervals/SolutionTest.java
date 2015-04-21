package MergeIntervals;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Utility.Interval;

public class SolutionTest {

	@Test
	public void testMerge() {
		Solution s = new Solution();
		int[][] input = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
		int[][] output = {{1, 6}, {8, 10}, {15, 18}};
		//int[][] input = {{4, 6}, {1, 2}, {1, 3}};
		//int[][] output = {{1, 3}, {4, 6}};
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		ArrayList<Interval> ans = new ArrayList<Interval>();
		for (int i=0;i<input.length;i++)
			intervals.add(new Interval(input[i][0], input[i][1]));
		for (int i=0;i<output.length;i++)
			ans.add(new Interval(output[i][0], output[i][1]));
		ArrayList<Interval> mis = s.merge(intervals);
		assertEquals("Merge size not agree", ans.size(), mis.size());
		for (int i=0;i<ans.size();i++) {
			assertEquals("start not agree", ans.get(i).start, mis.get(i).start);
			assertEquals("end not agree", ans.get(i).end, mis.get(i).end);
		}
	}

}
