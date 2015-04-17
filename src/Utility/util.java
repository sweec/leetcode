package Utility;

public class util {
	public static char[][] getCharArray(String[] strs) {
		char[][] chs = new char[strs.length][];
		for (int i=0;i<strs.length;i++)
			chs[i] = strs[i].toCharArray();
		return chs;
	}
	
}
