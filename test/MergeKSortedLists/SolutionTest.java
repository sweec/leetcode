package MergeKSortedLists;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Utility.ListNode;

public class SolutionTest {

	@Test
	public void testMergeKLists() {
		Solution s = new Solution();
		ArrayList<ListNode> lists = new ArrayList<ListNode>();
		int[][] nums = {{-6,-3,-1,1,2,2,2},{-10,-8,-6,-2,4},{-2},{-8,-4,-3,-3,-2,-1,1,2,3},{-8,-6,-5,-4,-2,-2,2,4}};
		int[] vals = {-10,-8,-8,-8,-6,-6,-6,-5,-4,-4,-3,-3,-3,-2,-2,-2,-2,-2,-1,-1,1,1,2,2,2,2,2,3,4,4};
		for (int i=0;i<nums.length;i++) {
			ListNode head = new ListNode(nums[i][0]);
			ListNode pre = head;
			for (int j=1;j<nums[i].length;j++) {
				ListNode cur = new ListNode(nums[i][j]);
				pre.next = cur;
				pre = cur;
			}
			lists.add(head);
		}
		ListNode r = s.mergeKLists(lists);
		for (int i=0;i<vals.length;i++) {
			assertEquals("value not agree", vals[i], r.val);
			r = r.next;
		}
	}

}
