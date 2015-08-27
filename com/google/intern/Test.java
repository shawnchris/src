package com.google.intern;

class FakeObject {
	@Override
	public int hashCode() {
        int fakehash = 1;
        return fakehash;
    }

	public boolean equals(FakeObject f) {
        return this.hashCode() == f.hashCode();
    }
	
}

public class Test {

	public static void main(String[] args) {
		Object a = new Object();
		Object b = new Object();
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		System.out.println(a.equals(b));
		FakeObject c = new FakeObject();
		FakeObject d = new FakeObject();
		System.out.println(c.hashCode());
		System.out.println(d.hashCode());
		System.out.println(c.equals(d));
		
		
		System.out.println(System.currentTimeMillis());
		System.out.println(log2(System.currentTimeMillis()));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(1 << 30);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Long.MAX_VALUE);
	}
	
	public static int log2(long n){
	    if(n <= 0) throw new IllegalArgumentException();
	    return 63 - Long.numberOfLeadingZeros(n);
	}
	
	

}
