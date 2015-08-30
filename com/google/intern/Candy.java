package com.google.intern;

public class Candy {
	public int candy(int[] ratings) {
        if (ratings==null) return 0;
        int len = ratings.length;
        if(len<=1) return 1;
        
        int[] candy = new int[len];
        for(int i=0; i<len; i++) candy[i]=1;
        
        for(int i=1; i<len; i++)
            if (ratings[i]>ratings[i-1])
                candy[i]=candy[i-1]+1;
        for(int i=len-1; i>0; i--)
            if (ratings[i-1]>ratings[i])
                candy[i-1]=Math.max(candy[i]+1,candy[i-1]);
        
        int sum=0;
        for(int i=0; i<len; i++) {
            sum += candy[i];
            System.out.print(candy[i]+ " ");
        }
        return sum;
    }
	public static void main(String[] args) {
		Candy c = new Candy();
		int[] input1 = {1, 2, 3, 2, 2, 1, 3, 1};
		System.out.println("\n"+c.candy(input1));
	}

}
