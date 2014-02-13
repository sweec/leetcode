package AddTwoNumbers;

import static org.junit.Assert.*;

import org.junit.Test;

import AddTwoNumbers.Solution.ListNode;

public class SolutionTest {

	@Test
	public void testAddTwoNumbers() {
		Solution s = new Solution();
		ListNode l1 = s.new ListNode(2);
		ListNode node = s.new ListNode(4);
		l1.next = node;
		ListNode cur = node;
		node = s.new ListNode(5);
		cur.next = node;
		ListNode l2 = s.new ListNode(5);
		node = s.new ListNode(6);
		l2.next = node;
		cur = node;
		node = s.new ListNode(4);
		cur.next = node;
		ListNode l = s.addTwoNumbers(l1, l2);
		assertEquals("1st digit not correct", 7, l.val);
		assertEquals("2nd digit not correct", 0, l.next.val);
		assertEquals("3rd digit not correct", 0, l.next.next.val);
		assertEquals("4th digit not correct", 1, l.next.next.next.val);
	}

}
