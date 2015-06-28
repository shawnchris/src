package com.leetcode.oj;

public class Pow {
	//Recursive
	public double pow1(double x, int n) {
		double temp=x;
		if(n==0)
			return 1;
		temp=pow1(x,n/2);
		if(n%2==0)
			return temp*temp;
		else 
		{
			if(n > 0)
				return x*temp*temp;
			else
				return (temp*temp)/x;
		}
	}
	/*Iterative O(lgn) iteration solution
	 * e.g. x^7=x^(1+2+4)=(x^1)(x^2)(x^4). 7=Binary(111).
	 */
	public double pow2(double x, int n) {
	    double result = 1;
	    int absn = n<0 ? n*-1 : n;
	    int curBit = 0;
	    double curResult = x;
	    for (int i=0; i<31; i++) {
	        if ((absn & (1 << i)) > 0) {
	            for (; curBit<i; curBit++) {
	                curResult *= curResult;
	            }
	            result *= curResult;
	        }
	    }
	    return n<0 ? 1/result : result;
	}
	
	public double pow3(double x, int n) {
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        double result = 1;
        for (double f = x; n > 0; n = n >> 1) {
            if (n % 2 == 1) {
                result *= f;
            }
            f = f * f;
        }
        return result;
    }
	public static void main(String[] args) {
		Pow pow = new Pow();
		System.out.println(pow.pow1(2, 2));
		System.out.println(pow.pow1(2, 3));
		System.out.println(pow.pow1(2, -2));
		System.out.println(pow.pow1(2, -3));

	}

}
