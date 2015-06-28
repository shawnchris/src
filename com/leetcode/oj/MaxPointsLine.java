package com.leetcode.oj;

import java.util.*;

class Point {
	int x;
	int y;
	Point() { x = 0; y = 0; }
	Point(int a, int b) { x = a; y = b; }
}

public class MaxPointsLine {

	public int maxPoints(Point[] points) {
		Hashtable<Integer, Integer> htx = new Hashtable<Integer, Integer>();
		Hashtable<Integer, Integer> hty = new Hashtable<Integer, Integer>();
		Hashtable<Integer, Integer> htxy = new Hashtable<Integer, Integer>();
		int maxx=0, maxy=0, maxxy=0;
		int x=0, y=0, xy=0, number=0;
		
		for (int i=0; i<points.length; i++) {
			x = points[i].x;
			y = points[i].y;
			xy = x-y;
			if (htx.containsKey(x)) {
				number=htx.get(x);
				htx.remove(x);
				htx.put(x, number+1);
				if (maxx<number+1) maxx=number+1;
			}
			else {
				htx.put(x, 1);
				if (maxx<1) maxx=1;
			}
			if (hty.containsKey(y)) {
				number=hty.get(y);
				hty.remove(y);
				hty.put(y, number+1);
				if (maxy<number+1) maxy=number+1;
			}
			else {
				hty.put(y, 1);
				if (maxy<1) maxy=1;
			}
			if (htxy.containsKey(xy)) {
				number=htxy.get(xy);
				htxy.remove(xy);
				htxy.put(xy, number+1);
				if (maxxy<number+1) maxxy=number+1;
			}
			else {
				htxy.put(xy, 1);
				if (maxxy<1) maxxy=1;
			}
		}
		
		return Math.max(maxxy, Math.max(maxx, maxy));
	}
	
	public static void main(String[] args) {
		Point[] test = new Point[10];
		test[0]=new Point(1,1);
		test[1]=new Point(2,2);
		test[2]=new Point(3,3);
		test[3]=new Point(4,4);
		test[4]=new Point(5,5);
		test[5]=new Point(6,6);
		test[6]=new Point(1,5);
		test[7]=new Point(2,5);
		test[8]=new Point(3,5);
		test[9]=new Point(4,5);
		
		MaxPointsLine mpl = new MaxPointsLine();
		System.out.println(mpl.maxPoints(test));

	}

}

