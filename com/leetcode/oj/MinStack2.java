package com.leetcode.oj;

import java.util.Stack;

public class MinStack2 {

	class Element
	{
		final int value;
		final int min;
		Element(final int value, final int min)
		{
			this.value = value;
			this.min = min;
		}
	}

	Stack<Element> stack = new Stack<>();

	public void push(int x) {
		int min;
		if (stack.empty())
			min=x;
		else
			min=Math.min(stack.peek().min, x);
		stack.push(new Element(x, min));
	}

	public void pop() {
		stack.pop();
	}

	public int top() {
		return stack.peek().value;
	}

	public int getMin() {
		return stack.peek().min;
	}


	public static void main(String[] args) {
		MinStack2 ms = new MinStack2();
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
		System.out.println(ms.getMin());

	}

}
