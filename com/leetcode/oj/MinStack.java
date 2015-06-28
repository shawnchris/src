package com.leetcode.oj;

import java.util.ArrayList;

class MinStack {
	private ArrayList<Integer> stack = new ArrayList<Integer>();
    private int size = 0;
    
    public void push(int x) {
        stack.add(x);
        size++;
    }

    public void pop() {
    	if (size>0) {
    		size--;
            stack.remove(size);
    	}
    }

    public int top() {
        return stack.get(size-1);
    }

    public int getMin() {
    	try{
    		if (size==0) throw new Exception();
    		else {
    			int temp = stack.get(0);
    			for (int i=1; i<size; i++)
    				if (temp > stack.get(i)) temp=stack.get(i);
    			return temp;
    		}
    	}
    	catch (Exception e) {
    		System.err.println("Empty stack error!");
    		return -1;
    	}
    }
}

class testMinStack {
    public static void main(String[] arg) {
    	MinStack ms = new MinStack();
    	ms.push(9);
    	ms.push(8);
    	ms.push(2);
    	ms.push(6);
    	ms.push(5);
    	ms.push(1);
    	ms.pop();
    	ms.pop();
    	System.out.println(ms.top());
    	System.out.println(ms.getMin());
    	ms.pop();
    	ms.pop();
    	ms.pop();
    	ms.pop();
    	ms.pop();
    	ms.pop();
    	ms.getMin();
    }
}

