// Sort an array like this a0<a1>a2<a3...

package j.algorithm;

import java.util.Arrays;
import java.util.Random;

public class Jsort2 {

	public static void main(String[] args) {
		int[] array =  {1,2,3,4,5,6,7,8,9};
		int[] array2 = {6,3,1,9,2,8,4,5,7};
		print_array(array);
		brute_force(array);
		print_array(array2);
		smart(array2);
		print_array(array2);
	}
	
	static void smart(int[] src) {
		Arrays.sort(src);
		for (int i=1; i<src.length-1; i=i+2) {
			int temp=src[i];
			src[i]=src[i+1];
			src[i+1]=temp;
		}
	}
	
	static void brute_force(int[]  src) {
		int[] dst = new int[src.length];
		int[] flag = new int[src.length];
		do {
			for (int i=0; i<dst.length; i++) { dst[i]=0; flag[i]=0; }
			int total=0;
			int random=0;
			Random rnd = new Random();
			while (total < dst.length) {
				random = rnd.nextInt(src.length);
				if (flag[random]==0) {
					dst[total] = src[random];
					total++;
					flag[random]=1;
				}
			}
		}while (!comply(dst));
		print_array(dst);
	}
	
	static boolean comply(int[] a) {
		if (a[0]<a[1] && a[1]>a[2] && a[2]<a[3] && a[3]>a[4] && a[4]<a[5] && a[5]>a[6] && a[6]<a[7] && a[7]>a[8])
			return true;
		else
			return false;
	}
	
	static void print_array(int[] a) {
		for (int i=0; i<a.length; i++) {
			System.out.print(a[i]+ " ");
		}
		System.out.println();
	}

}
