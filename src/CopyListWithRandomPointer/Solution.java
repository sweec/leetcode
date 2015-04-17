package CopyListWithRandomPointer;

import java.util.HashMap;

import Utility.RandomListNode;

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map =
        		new HashMap<RandomListNode, RandomListNode>();
        RandomListNode fakeHead = new RandomListNode(0);
        RandomListNode old = head, copy = fakeHead;
        // copy node except random pointer
        while (old != null) {
        	copy.next = new RandomListNode(old.label);
        	copy = copy.next;
        	map.put(old, copy);
        	old = old.next;
        }
        // now copy random pointer
        old = head; copy = fakeHead.next;
        while (old != null) {
        	copy.random = map.get(old.random);
        	copy = copy.next;
        	old = old.next;
        }
        return fakeHead.next;
    }
}
