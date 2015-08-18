package com.google.intern;

import java.util.*;

public class SkyLine {
	public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<int[]>();
        
        return result;
    }
	
	public static void main(String[] args) {
		int[][] input1 = { {1,11,5}, {2,6,7}, {3,13,9}, {12,7,16}, {14,3,25},
	         {19,18,22}, {23,13,29}, {24,4,28} };
		
		SkyLine sl = new SkyLine();
		List<int[]> result = sl.getSkyline(input1);
		for (int[] pair : result)
			System.out.print("(" + pair[0] + "," + pair[1] + ") ");
	}

}
