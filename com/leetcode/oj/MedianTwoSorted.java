package com.leetcode.oj;

public class MedianTwoSorted {
	public double findMedianSortedArrays(int A[], int B[]) {
        int alen = A.length;
        int blen = B.length;
        int mlen = (alen + blen)/2+1;
        int a=0;
        int b=0;
        int c=0;
        double mid=0;
        double mid_1=0;
        while (a < alen && b < blen && c < mlen) {
            if (A[a]<=B[b]) {
                mid_1 = mid;
                mid = A[a];
                a++;
            }
            else {
                mid_1 = mid;
                mid = B[b];
                b++;
            }
            c++;
        }
        while (a < alen && c < mlen) {
            mid_1 = mid;
            mid = A[a];
            a++;
            c++;
        }
        while (b < blen && c < mlen) {
            mid_1 = mid;
            mid = B[b];
            b++;
            c++;
        }
        if ((alen+blen)%2 == 0)
            return (double)((mid+mid_1)/2);
        else
            return (double)mid;
    }
	
	public double findMedianSortedArrays2(int A[], int B[]) {
		int n = A.length;
		int m = B.length;
		// the following call is to make sure len(A) <= len(B).
		// yes, it calls itself, but at most once, shouldn't be
		// consider a recursive solution
		if (n > m)
			return findMedianSortedArrays2(B, A);

		// now, do binary search
		int k = (n + m - 1) / 2;
		int l = 0, r = Math.min(k, n); // r is n, NOT n-1, this is important!!
		while (l < r) {
			int midA = (l + r) / 2;
			int midB = k - midA;
			if (midB > k || A[midA] < B[midB])
				l = midA + 1;
			else
				r = midA;
		}

		// after binary search, we almost get the median because it must be between
		// these 4 numbers: A[l-1], A[l], B[k-l], and B[k-l+1] 

		// if (n+m) is odd, the median is the larger one between A[l-1] and B[k-l].
		// and there are some corner cases we need to take care of.
		int a = Math.max(l > 0 ? A[l - 1] : Integer.MIN_VALUE, k - l >= 0 ? B[k - l] : Integer.MIN_VALUE);
		if (((n + m) & 1) == 1)
			return (double) a;

		// if (n+m) is even, the median can be calculated by 
		//      median = (max(A[l-1], B[k-l]) + min(A[l], B[k-l+1]) / 2.0
		// also, there are some corner cases to take care of.
		int b = Math.min(l < n ? A[l] : Integer.MAX_VALUE, k - l + 1 < m ? B[k - l + 1] : Integer.MAX_VALUE);
		return (a + b) / 2.0;
	}
	
	public static void main(String[] args) {
		int[] A = {};
		int[] B = {2,3};
		MedianTwoSorted mts = new MedianTwoSorted();
		System.out.println(mts.findMedianSortedArrays(A, B));
		System.out.println(mts.findMedianSortedArrays2(A, B));
		System.out.println(mts.findMedianSortedArrays2(new int[]{2,3}, new int[]{6,7,8,9,11,12,13,14,15}));

	}

}
