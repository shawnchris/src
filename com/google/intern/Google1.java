package com.google.intern;

/*
 * Given a sorted input array, and A, B, C, calculate y = Ax^2 + Bx + C.
 * The result array should be in sorted order too.
 */
enum ORDER {
	UNCHANGE,
	REVERSE,
	REVERSE_LEFT,
	REVERSE_RIGHT,
}
public class Google1 {
	public int[] func(int[] input, int A, int B, int C) {
		if (input == null) return null;
		int len = input.length;
		if (len == 0) return new int[0];
		if (A == 0) {
			if (B >= 0)
				return calc(input, A, B, C, ORDER.UNCHANGE);
			else
				return calc(input, A, B, C, ORDER.REVERSE);
		}
		
		int idx = searchArray(input, -1 * B / (2 * A));
		if (idx == -1 || idx == len) { // single order
			if (A > 0 && idx == -1 || A < 0 && idx == len) // all increase
				return calc(input, A, B, C, ORDER.UNCHANGE);
			if (A > 0 && idx == len || A < 0 && idx == -1) // all decrease
				return calc(input, A, B, C, ORDER.REVERSE);
		}
		else { // need manipulate
			if (A > 0)
				return calc(input, A, B, C, ORDER.REVERSE_LEFT);
			else
				return calc(input, A, B, C, ORDER.REVERSE_RIGHT);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
