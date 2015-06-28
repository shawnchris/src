package j.algorithm;

import java.util.Hashtable;

public class Fibonacci {
	
	// Traditional 
	long Fib1(long n) {
		System.out.println("Calc Fib:"+n);		
		if (n<=1) 
			return 1;
		else
			return Fib1(n-1) + Fib1(n-2);
	}
	
	// Dynamic
	public Hashtable res = new Hashtable();
	long Fib2(long n) {
		System.out.println("Calc Fib:"+n);
		if (res.containsKey(n)) 
			return (long)res.get(n);
		else {
			long x, y;
			if (res.containsKey(n-1))
				x = (long)res.get(n-1);
			else {
				x = Fib2(n-1);
				res.put(n - 1, x);
			}
			if (res.containsKey(n-2))
				y = (long)res.get(n-2);
			else {
				y = Fib2(n-2);
				res.put(n - 2, y);
			}
			return x + y;
		}
	}
	
	// Dynamic non-recursive
	long Fib3(long n) {
		long[] fib = new long[(int)n+1];
		fib[0] = 1;
		fib[1] = 1;
		for (int i=2; i<=n; i++)
			fib[i]=fib[i-1]+fib[i-2];
		return fib[(int)n];
	}
	
	public static void main(String[] arg) {
		Fibonacci fib = new Fibonacci();
		
		System.out.println(fib.Fib1(10));
		
		fib.res.put((long)0, (long)1);
		fib.res.put((long)1, (long)1);
		System.out.println(fib.Fib2(10));
		
		System.out.println(fib.Fib3(10));
	}

}
