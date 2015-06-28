package com.leetcode.oj;

import java.util.*;

public class Sudoku {
	public static int counter = 0;
	
	public int[][] solution(int[][] array) {
		int[][] a = new int[9][9];
		HashSet<?>[] rows = new HashSet<?>[9];
		HashSet<?>[] cols = new HashSet<?>[9];
		int row = 0, col = 0;
		
		for (int i = 0; i<9; i++)
		    rows[i] = new HashSet<Integer>();
		for (int i = 0; i<9; i++)
		    cols[i] = new HashSet<Integer>();
		
		for (int i=0; i<9; i++)
			for (int j=0; j<9; j++) {
				a[i][j] = array[i][j];
				if (a[i][j]!=0) {
					((HashSet<Integer>)rows[i]).add(a[i][j]);
					((HashSet<Integer>)cols[j]).add(a[i][j]);
				}
			}
		
		while (row>=0) {
			if (array[row][col]!=0) { //Pre-given number, can't change it.
				if (row==8 && col==8) return a; //Find a solution.
				else {
					col++;
					if (col>8) {
						row++;
						col=0;
					}
				}
			}
			else {
				int num = next_not_used(a[row][col], row, col, rows, cols, a);
				if (num>0) { //Forward
					a[row][col] =  num;
					if (row==8 && col==8) return a; //Find a solution.
					else {
						((HashSet<Integer>)rows[row]).add(a[row][col]);
						((HashSet<Integer>)cols[col]).add(a[row][col]);
						col++;
						if (col>8) {
							row++;
							col=0;
						}
					}
				}
				else { //Back
					if (a[row][col] != 0) {
						((HashSet<Integer>)rows[row]).remove(a[row][col]);
						((HashSet<Integer>)cols[col]).remove(a[row][col]);
					}
					a[row][col] = 0;
					do {
						col--;
						if (col<0) {
							row--;
							col=8;
						}
					} while (row>=0 && array[row][col]!=0);
					if (row>=0 && col>=0) {
						((HashSet<Integer>)rows[row]).remove(a[row][col]);
						((HashSet<Integer>)cols[col]).remove(a[row][col]);
					}
				}
			}
			/*
			for (int i=0; i<9; i++) {
				for (int j=0; j<9; j++)
					System.out.print(a[i][j] + " ");
				System.out.println();
			}
			for (int i=0; i<9; i++)
				System.out.println((HashSet<Integer>)rows[i]);
			for (int i=0; i<9; i++)
				System.out.println((HashSet<Integer>)cols[i]);
			System.out.println();
			*/
		}
		
		return null;
	}
	
	int next_not_used(int n, int row, int col, HashSet<?>[] rows, HashSet<?>[] cols, int[][] a) {
		counter++;
		
		int scol = (col / 3) * 3;
		int srow = (row / 3) * 3;
		boolean in_small = false;
		
		do {
			n++;
			in_small = false;
			for (int i=srow; i<srow+3; i++)
				for (int j=scol; j<scol+3; j++)
					if (i!=row && j!=col && a[i][j]==n)
						in_small = true;
		} while(n<10 && (((HashSet<Integer>)rows[row]).contains(n) || ((HashSet<Integer>)cols[col]).contains(n) || in_small));
		
		return n==10 ? -1 : n;
	}
	
	public static void main(String[] args) {
		int[][] test1 = {
			{5, 0, 0, 0, 8, 0, 0, 1, 0},
			{0, 4, 9, 0, 0, 7, 2, 0, 0},
			{7, 1, 0, 2, 0, 0, 4, 0, 0},
			{0, 0, 5, 0, 0, 0, 0, 0, 1},
			{0, 0, 2, 0, 0, 0, 5, 0, 0},
			{3, 0, 0, 0, 0, 0, 8, 0, 0},
			{0, 0, 6, 0, 0, 3, 0, 8, 9},
			{0, 0, 1, 5, 0, 0, 6, 7, 0},
			{0, 9, 0, 0, 2, 0, 0, 0, 4},
		};
		int[][] test2 = {
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 9, 4, 7, 0, 1, 0, 0},
				{0, 1, 3, 0, 0, 0, 0, 0, 0},
				{0, 7, 0, 5, 0, 4, 0, 2, 0},
				{0, 3, 0, 9, 0, 7, 0, 4, 0},
				{0, 9, 0, 8, 0, 6, 0, 3, 0},
				{0, 0, 0, 0, 0, 0, 8, 6, 0},
				{0, 0, 2, 0, 9, 3, 7, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
			};
		int[][] test3 = {
				{9, 0, 1, 0, 8, 0, 2, 0, 0},
				{6, 0, 0, 0, 0, 0, 0, 0, 3},
				{0, 3, 0, 7, 0, 0, 5, 1, 0},
				{0, 0, 0, 0, 7, 1, 0, 9, 0},
				{0, 0, 4, 2, 0, 9, 8, 0, 0},
				{0, 9, 0, 4, 5, 0, 0, 0, 0},
				{0, 5, 2, 0, 0, 3, 0, 7, 0},
				{8, 0, 0, 0, 0, 0, 0, 0, 2},
				{0, 0, 7, 0, 4, 0, 9, 0, 8},
			};
		int[][] test4 = {
				{6, 0, 3, 0, 0, 2, 0, 0, 0},
				{2, 0, 0, 0, 6, 3, 1, 0, 0},
				{0, 0, 1, 9, 0, 0, 0, 2, 0},
				{0, 5, 0, 0, 0, 8, 0, 0, 0},
				{7, 3, 0, 0, 0, 0, 0, 4, 8},
				{0, 0, 0, 4, 0, 0, 0, 3, 0},
				{0, 7, 0, 0, 0, 5, 8, 0, 0},
				{0, 0, 8, 6, 3, 0, 0, 0, 4},
				{0, 0, 0, 7, 0, 0, 6, 0, 2},
			};
		int[][] test5 = {
				{0, 6, 0, 0, 0, 2, 0, 5, 8},
				{0, 0, 8, 0, 5, 0, 1, 0, 0},
				{0, 4, 0, 0, 0, 0, 0, 9, 2},
				{9, 2, 0, 0, 6, 0, 5, 0, 0},
				{0, 0, 4, 0, 0, 0, 2, 0, 0},
				{0, 0, 6, 0, 4, 0, 0, 8, 9},
				{7, 1, 0, 0, 0, 0, 0, 3, 0},
				{0, 0, 3, 0, 9, 0, 6, 0, 0},
				{6, 8, 0, 4, 0, 0, 0, 7, 0},
			};
		Sudoku sdk = new Sudoku();
		
		int res[][] = sdk.solution(test1);
		if (res != null)
			for (int i=0; i<9; i++) {
				for (int j=0; j<9; j++)
					System.out.print(res[i][j] + " ");
				System.out.println();
			}
		else
			System.out.println("No Solution!");
		System.out.println("Time complexity: "+counter+"\n");
		counter=0;
		
		res = sdk.solution(test2);
		if (res != null)
			for (int i=0; i<9; i++) {
				for (int j=0; j<9; j++)
					System.out.print(res[i][j] + " ");
				System.out.println();
			}
		else
			System.out.println("No Solution!");
		System.out.println("Time complexity: "+counter+"\n");
		counter=0;
		
		res = sdk.solution(test3);
		if (res != null)
			for (int i=0; i<9; i++) {
				for (int j=0; j<9; j++)
					System.out.print(res[i][j] + " ");
				System.out.println();
			}
		else
			System.out.println("No Solution!");
		System.out.println("Time complexity: "+counter+"\n");
		counter=0;
		
		res = sdk.solution(test4);
		if (res != null)
			for (int i=0; i<9; i++) {
				for (int j=0; j<9; j++)
					System.out.print(res[i][j] + " ");
				System.out.println();
			}
		else
			System.out.println("No Solution!");
		System.out.println("Time complexity: "+counter+"\n");
		counter=0;
		
		res = sdk.solution(test5);
		if (res != null)
			for (int i=0; i<9; i++) {
				for (int j=0; j<9; j++)
					System.out.print(res[i][j] + " ");
				System.out.println();
			}
		else
			System.out.println("No Solution!");
		System.out.println("Time complexity: "+counter+"\n");
		counter=0;
	}

}
