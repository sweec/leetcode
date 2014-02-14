package CopyListWithRandomPointer;

import static org.junit.Assert.*;

import org.junit.Test;

import CopyListWithRandomPointer.Solution.RandomListNode;

public class SolutionTest {

	@Test
	public void testCopyRandomList() {
		Solution s = new Solution();
		RandomListNode head = s.new RandomListNode(1);
		RandomListNode cur = head;
		int[] data = {1, 2, 3, 4, 5};
		for (int i = 1;i < data.length;i++) {
			RandomListNode node = s.new RandomListNode(data[i]);
			cur.next = node;
			node.random = cur;
			cur = node;
		}
		RandomListNode copy = s.copyRandomList(head);
		RandomListNode old = head; cur = copy;
		int[] val = {1, 2, 3, 4, 5};
		for (int i = 1;i <= val.length;i++) {
			assertEquals("node "+i+" value not correct", val[i-1], cur.label);
			if (i == 1)
				assertEquals("node "+i+" has wrong random pointer", null, cur.random);
			else {
				assertEquals("The random node of node "+i+" has wrong value", val[i-2], cur.random.label);
				if (cur.random == old.random)
					fail("The random node of node "+i+" is a shallow copy of old one.");
			}
			cur = cur.next;
			old = old.next;
		}
	}

}
