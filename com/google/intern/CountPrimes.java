package com.google.intern;

//Sieve of Eratosthenes

public class CountPrimes {
	public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        
        for (int i = 2; i < n; i++)
            isPrime[i] = true;
        
        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i])
                continue;
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
        
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i])
                count++;
        }
        
        return count;
    }
	
	public static void main(String[] args) {
		CountPrimes cp = new CountPrimes();
		System.out.println(cp.countPrimes(1));
		System.out.println(cp.countPrimes(2));
		System.out.println(cp.countPrimes(3));
		System.out.println(cp.countPrimes(100));
		System.out.println(cp.countPrimes(1000));
		System.out.println(cp.countPrimes(10000));
		System.out.println(cp.countPrimes(100000));

	}

}
