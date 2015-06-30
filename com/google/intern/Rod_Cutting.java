package com.google.intern;

public class Rod_Cutting {
	// Dynamic programming solution
	public int bottom_up_rod_cutting(int[] price, int len) {
		int[] max_profit = new int[len+1];
		max_profit[0] = 0;
		for (int i=1; i<=len; i++) {
			int profit = Integer.MIN_VALUE;
			for (int cut=1; cut<=i; cut++)
				profit = Math.max(profit, price[cut]+max_profit[i-cut]);
			max_profit[i] = profit;
		}
		return max_profit[len];
	}
	
	public static void main(String[] args) {
		Rod_Cutting rc = new Rod_Cutting();
		int[] price = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
		System.out.println(rc.bottom_up_rod_cutting(price, 5));
	}
}
