package SimplifyPath;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSimplifyPath() {
		Solution s = new Solution();
		String[] paths = {"/home/", "/a/./b/../../c/", "/.//a/../.", "/.../", "/../a/"};
		String[] sps = {"/home", "/c", "/", "/...", "/a"};
		for (int i=0;i<paths.length;i++)
			assertEquals("Simplified path is wrong", sps[i], s.simplifyPath(paths[i]));
	}

}
