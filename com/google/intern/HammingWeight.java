package com.google.intern;

public class HammingWeight {
	// you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        if (n < 0) {
            count++;
            n = n & 0x7fffffff;
        }
        
        while (n > 0) {
            if ((n & 1) == 1)
                count++;
            n = n >> 1;
        }
        
        return count;
    }
	public static void main(String[] args) {
		HammingWeight hw = new HammingWeight();
		
		System.out.println(hw.hammingWeight(-1));

	}

}
