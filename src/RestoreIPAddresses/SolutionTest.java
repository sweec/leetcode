package RestoreIPAddresses;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testRestoreIpAddresses() {
		Solution s = new Solution();
		String str = "25525511135";
		String[] ans = {"255.255.11.135", "255.255.111.35"};
		ArrayList<String> ips = s.restoreIpAddresses(str);
		assertEquals("Number of IPs not agree", ans.length, ips.size());
		for (int i=0;i<ans.length;i++)
			assertEquals("ip not agree", ans[i], ips.get(i));
		str = "010010";
		ans[0] = "0.10.0.10";
		ans[1] = "0.100.1.0";
		ips = s.restoreIpAddresses(str);
		assertEquals("Number of IPs not agree", ans.length, ips.size());
		for (int i=0;i<ans.length;i++)
			assertEquals("ip not agree", ans[i], ips.get(i));
	}

}
