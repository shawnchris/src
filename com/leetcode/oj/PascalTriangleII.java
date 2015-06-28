package com.leetcode.oj;

import java.util.Arrays;
import java.util.List;

public class PascalTriangleII {

	public List<Integer> getRow(int rowIndex) {
		if (rowIndex<=0) return Arrays.asList();
		Integer[] array = new Integer[rowIndex];
		array[rowIndex-1]=1;

		for(int i=2; i<=rowIndex; i++)
			for (int j=rowIndex-i; j<rowIndex-1; j++)
				if (j==rowIndex-i)
					array[j]=1;
				else
					array[j] = array[j]+array[j+1];

		return Arrays.asList(array);
	}


	public static void main(String[] args) {
		PascalTriangleII pt = new PascalTriangleII();

		List<Integer> result = pt.getRow(9);

		System.out.println(result);

	}

}
