package com.google.intern;

public class MaxProfit {
	public int maxProfit3(int[] prices) {
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
            System.out.print(result+" ");
        }
        System.out.println();
        
        // backward, calculate max profit from now, and the sum with history
        for (int i=len-1;i>=0;i--){
            high=Math.max(high,prices[i]);
            result=Math.max(result,high-prices[i]+profits_history[i]);
            System.out.print(result+" ");
        }
        return result;
    }
	public static void main(String[] args) {
		MaxProfit mp = new MaxProfit();
		int[] input1 = {3, 8 ,9, 6, 3 ,7, 6, 5};
		System.out.println(mp.maxProfit3(input1));
	}

}
