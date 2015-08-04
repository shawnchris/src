package com.google.intern;

import java.util.*;

public class MyQueue {
	Stack<Integer> s = new Stack<Integer>();
    Stack<Integer> t = new Stack<Integer>();
    
    void move() {
        int len = s.size();
        for (int i = 0; i < len - 1; i++)
            t.push(s.pop());
    }
    
    void restore() {
        int len = t.size();
        for (int i = 0; i < len; i++)
            s.push(t.pop());
    }
    
    // Push element x to the back of queue.
    public void push(int x) {
        s.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        move();
        s.pop();
        restore();
    }

    // Get the front element.
    public int peek() {
        move();
        int result = s.peek();
        restore();
        return result;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s.isEmpty();
    }
    
	public static void main(String[] args) {
		MyQueue q = new MyQueue();
		q.push(1);
		q.push(2);
		q.push(3);
		System.out.println(q.peek());
	}
}
