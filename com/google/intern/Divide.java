package com.google.intern;

public class Divide {

	public int divide(int dividend, int divisor) {
        if (divisor == 1) // Trival case 1
            return dividend;
        if (divisor == -1) {// Trival case 2
        	long temp = -1 * (long) dividend;
            if (temp >= Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else
                return -dividend;
        }
        
        // Use negative integers to avoid integer overflow
        if (dividend > 0)
            return -divide(-dividend, divisor);
        if (divisor > 0)
            return -divide(dividend, -divisor);

        if (dividend > divisor) // Trivial case 3
            return 0;

        // Find the highest mult = (divisor * 2^shifts) which is <= dividend
        // by shifting mult to the left without causing an overflow.
        // At most (log2(|dividend|) - log2(|divisor|) + 1) iterations.
        int min_divisor = Integer.MIN_VALUE >> 1;
        int mult = divisor; // = divisor * 2^shifts
        int shifts = 0;
        while ((mult >= min_divisor) && (mult > dividend)) {
            mult <<= 1;
            ++shifts;
        }

        // Compute the result by shifting mult to the right.
        // At most (log2(|dividend|) - log2(|divisor|) + 1) iterations for the outer loop.
        // At most (log2(|dividend|) - log2(|divisor|) + 1) iterations for the inner loop
        // (in total, not per outer iteration).
        int result = 0;
        int power = 1 << shifts; // = 2^shifts
        while (dividend <= divisor) {
            shifts = 0;
            while (mult < dividend) {
                mult >>= 1;
                ++shifts;
            }
            dividend -= mult;
            power >>= shifts;
            result |= power; // Adds power to result
        }

        return result;
    }
	
	public static void main(String[] args) {
		Divide d = new Divide();
		System.out.println(Integer.MAX_VALUE);
		System.out.println(d.divide(-2147483648, -1));
	}

}
