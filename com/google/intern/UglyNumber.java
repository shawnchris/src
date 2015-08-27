package com.google.intern;

public class UglyNumber {
	public int nthUglyNumber(int n) {
        if (n == 1) return 1;
        int[] res = new int[n];
        res[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        
        for (int i = 1; i < n; i++) {
            int n2 = res[p2] * 2, n3 = res[p3] * 3, n5 = res[p5] * 5;
            res[i] = Math.min(n2, Math.min(n3, n5));
            if (res[i] % 2 == 0) p2++;
            if (res[i] % 3 == 0) p3++;
            if (res[i] % 5 == 0) p5++;
        }
        
        return res[n-1];
    }
	
	public static void main(String[] args) {
		UglyNumber nu = new UglyNumber();
		System.out.println(nu.nthUglyNumber(6));
	}

}
