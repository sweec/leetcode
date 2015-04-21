package MergeKSortedLists;

import java.util.ArrayList;

import Utility.ListNode;

public class Solution {
	
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		if (lists == null || lists.isEmpty())
			return null;
		int n = lists.size();
		if (n == 1)
			return lists.get(0);
		ListNode[] heap = new ListNode[n+1];
		int index = 0;
		for (int i=0;i<n;i++) {
			ListNode node = lists.get(i);
			if (node != null)
				heap[++index] = node;
		}
		if (index == 0)
			return null;
		if (index == 1)
			return heap[1];
		for (int i=index-1;i>0;i--)
			rebuild(heap, i, index);
		ListNode head = heap[1];
		int last = index;
		do {
			ListNode pre = heap[1];
			if (heap[1].next != null)
				heap[1] = heap[1].next;
			else {
				heap[1] = heap[last];
				heap[last] = null;
				last--;
				if (last == 1) {
					pre.next = heap[1];
					break;
				}
			}
			rebuild(heap, 1, index);
			pre.next = heap[1];
		} while (true);
		return head;
	}

	private void rebuild(ListNode[] heap, int index, int n) {
		do {
			ListNode p = null, l = null, r = null;
			if (n >= index)
				p = heap[index];
			if (p == null)
				break;
			if (n >= (index << 1))
				l = heap[index << 1];
			if (n >= (index << 1) + 1)
				r = heap[(index << 1) + 1];
			if (l == null && r == null)
				break;
			if (l != null && (r == null || r.val >= l.val)) {
				if (p.val > l.val) {
					heap[index] = l;
					heap[index << 1] = p;
					index <<= 1;
				} else
					break;
			} else if (r != null && (l == null || l.val >= r.val)) {
				if (p.val > r.val) {
					heap[index] = r;
					heap[(index << 1)+1] = p;
					index = (index << 1)+1;
				} else
					break;
			}
		} while (true);
	}
}
