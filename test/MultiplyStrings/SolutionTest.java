package MultiplyStrings;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testMultiply() {
		Solution s = new Solution();
		String[] num1s = {"00", "123456789", "56", "123", "12300", "9369162965141127216164882458728854782080715827760307787224298083754"};
		String[] num2s = {"123", "987654321", "999", "123", "12300", "7204554941577564438"};
		String[] ans = {"0", "121932631112635269", "55944", "15129", "151290000", "67500649338953014190022427720009974152122888684303491539825680400401937831201855940252"};
		for (int i=0;i<num1s.length;i++)
			assertEquals("result not agree", ans[i], s.multiply(num1s[i], num2s[i]));
	}

}
