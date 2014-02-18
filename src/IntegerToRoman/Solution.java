package IntegerToRoman;

public class Solution {
    public String intToRoman(int num) {
    	if (num < 1 || num > 3999)
    		return null;
        String[] RomansI = {"M", "C", "X", "I"};
        String[] RomansV = {"", "D", "L", "V"};
        StringBuffer sb = new StringBuffer();
        int divisor = 1000;
        for (int i = 0;i < 4;i++) {
        	int d = num / divisor;
        	num -= d * divisor;
        	divisor /= 10;
        	
        	if (d > 0 && d < 4) {
        		for (int j=0;j<d;j++)
        			sb.append(RomansI[i]);
        	} else if (d == 4) {
        		sb.append(RomansI[i]+RomansV[i]);
        	} else if (d >= 5 && d < 9) {
        		sb.append(RomansV[i]);
        		for (int j=0;j<d-5;j++)
        			sb.append(RomansI[i]);
        	} else if (d == 9) {
        		sb.append(RomansI[i]);
        		sb.append(RomansI[i-1]);
        	}
        }
        return sb.toString();
    }
}
