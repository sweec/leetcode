package CloneGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import Utility.UndirectedGraphNode;

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	if (node == null)
    		return null;
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        copy.neighbors = node.neighbors;
        Stack<UndirectedGraphNode> s = new Stack<UndirectedGraphNode>();
        s.push(copy);
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        map.put(node, copy);
        while (!s.isEmpty()) {
        	UndirectedGraphNode self = s.pop();
        	ArrayList<UndirectedGraphNode> neighbors = self.neighbors;
        	self.neighbors = new ArrayList<UndirectedGraphNode>();
        	for (UndirectedGraphNode nb:neighbors) {
        		if (map.containsKey(nb))
        			self.neighbors.add(map.get(nb));
        		else {
        			UndirectedGraphNode n = new UndirectedGraphNode(nb.label);
        			n.neighbors = nb.neighbors;
        			self.neighbors.add(n);
        			s.push(n);
        			map.put(nb, n);
        		}
        	}
        }
        return copy;
    }
}
