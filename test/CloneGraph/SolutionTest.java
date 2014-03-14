package CloneGraph;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import CloneGraph.Solution.UndirectedGraphNode;

public class SolutionTest {

	@Test
	public void testCloneGraph() {
		Solution s = new Solution();
		UndirectedGraphNode node0 = s.new UndirectedGraphNode(0);
		UndirectedGraphNode node1 = s.new UndirectedGraphNode(1);
		UndirectedGraphNode node2 = s.new UndirectedGraphNode(2);
		node0.neighbors.add(node1); node0.neighbors.add(node2);
		node1.neighbors.add(node0); node1.neighbors.add(node2);
		node2.neighbors.add(node0); node2.neighbors.add(node1);
		node2.neighbors.add(node2);
		UndirectedGraphNode n0 = s.cloneGraph(node0);
		assertEquals("node 0 label not agree", 0, n0.label);
		ArrayList<UndirectedGraphNode> nbs = n0.neighbors;
		assertEquals("node 0 neighbor number not agree", 2, nbs.size());
		UndirectedGraphNode n1 = nbs.get(0), n2 = nbs.get(1);
		assertEquals("node 1 label not agree", 1, n1.label);
		assertEquals("node 2 label not agree", 2, n2.label);
		assertEquals("node 1 neighbor number not agree", 2, n1.neighbors.size());
		assertEquals("node 2 neighbor number not agree", 3, n2.neighbors.size());
	}

}
