package WordLadderII;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testFindLadders() {
		Solution s = new Solution();
		
		String start = "hit", end = "cog";
		String[] strs = {"hot","dot","dog","lot","log"};
		HashSet<String> dict = new HashSet<String>();
		for (String str:strs)
			dict.add(str);
		String[][] ans = {{"hit","hot","dot","dog","cog"}, {"hit","hot","lot","log","cog"}};
		ArrayList<ArrayList<String>> ladders = s.findLadders(start, end, dict);
		assertEquals("ladder number not agree", ans.length, ladders.size());
		for (int i=0;i<ans.length;i++) {
			assertEquals("ladder size not agree", ans[i].length, ladders.get(i).size());
			for (int j=0;j<ans[i].length;j++)
				assertEquals("ladder word not agree", ans[i][j], ladders.get(i).get(j));
		}
	}

}
