package ReverseBits;

public class Solution {
    static int[] reversed = {
        0, 1<<3, 1<<2, (1<<3)+(1<<2), 1<<1, (1<<3)+(1<<1), (1<<2)+(1<<1), (1<<3)+(1<<2)+(1<<1), 1, (1<<3)+1, 
        (1<<2)+1, (1<<3)+(1<<2)+1, (1<<1)+1, (1<<3)+(1<<1)+1, (1<<2)+(1<<1)+1, (1<<3)+(1<<2)+(1<<1)+1
    };
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int reversed_n = 0;
        // method 1, use 4 bits lookup table, 298ms
        for (int i=0;i<32;i=i+4)
            reversed_n |= reversed[((n >>> i) & 0xF)] << (28 - i);
        return reversed_n;
    }
}
