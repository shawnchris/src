package com.leetcode.oj;

import java.util.*;


public class MaximumProfit {
	// Only one transaction
	public int maxProfit(int[] prices) {
		int len=prices.length;
		if (len<=1) return 0;

		int[] profit = new int[len];
		int[] sum = new int[len];
		int maxprofit=0;
		profit[0]=0;
		sum[0]=0;

		for (int i=1; i<len; i++) {
			profit[i]=prices[i]-prices[i-1];
			sum[i]=Math.max(profit[i], profit[i]+sum[i-1]);
			maxprofit=Math.max(maxprofit, sum[i]);
		}

		return maxprofit;
	}
	// You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). 
	// However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
	// Greedy
	public int maxProfitII(int[] prices) {
		int len=prices.length;
		if (len<=1) return 0;

		int maxprofit=0;
		int profit=0;

		for (int i=1; i<len; i++) {
			profit=prices[i]-prices[i-1];
			if (profit>0) maxprofit = maxprofit + profit;
		}

		return maxprofit;
	}
	// You may complete at most two transactions.
	/*
	 * First consider the case that when we are only allowed to make one transaction. we can handle this easily with DP. 
	 * If we move forward, any new price we meet will only affect our history result by two ways:
	 * will it be so low that it beats our previous lowest price? will it be so high that we should instead sell on this time to 
	 * gain a higher profit (than the history record)? Similarly, we can move backward with the highest price and profit in record. 
	 * Either way would take O(n) time. Now consider the two transaction case. Since there will be no overlaps, we are actually 
	 * dividing the whole time into two intervals.
	 * We want to maximize the profit in each of them so the same method above will apply here. We are actually trying to break 
	 * the day at each time instance, by adding the potential max profit before and after it together. By recording history and 
	 * future for each time point, we can again do this within O(n) time.
	 */
	public int maxProfitIII(int[] prices) {
		int len=prices.length;
		if (len<=1) return 0;
		
        int result=0;
        int low=prices[0],high=prices[len-1];

        int[] profits_history = new int[len];
        
        // forward, calculate max profit until this time
        for (int i=0;i<len;i++){
            low=Math.min(low,prices[i]);
            result=Math.max(result,prices[i]-low);
            profits_history[i]=result;
        }
        
        // backward, calculate max profit from now, and the sum with history
        for (int i=len-1;i>=0;i--){
            high=Math.max(high,prices[i]);
            result=Math.max(result,high-prices[i]+profits_history[i]);
        }
        return result;
	}
	public static void main(String[] args) {
		MaximumProfit mp = new MaximumProfit();
		int[] test1 = new int[] {6,1,3,2,4,7,6,5,4,5,6}; 
		int[] test2 = new int[] {3,2,6,5,0,3};

		System.out.println(mp.maxProfit(test1));
		System.out.println(mp.maxProfitII(test1));
		System.out.println(mp.maxProfitIII(test1));
		System.out.println(mp.maxProfitIII(test2));

	}

}
