package com.leetcode.oj;

import java.util.Stack;

public class ReverseLinkedList {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head.next==null ||  m==n) 
			return head;
		Stack<ListNode> stack = new Stack<ListNode>();
		ListNode zero = new ListNode(0);
		zero.next=head;
		ListNode l=null, r=null, p;
		p=zero;
		int size=0;
		while (p!=null) {
			if (size==m-1) l=p;
			if (size==n+1) r=p;
			if (size>=m && size <=n)
				stack.add(p);
			p=p.next;
			size++;
		}
		p=l;
		while (!stack.isEmpty()) {
			p.next=stack.pop();
			p=p.next;
		}
		p.next=r;
		
		return zero.next;
		
	}
	public static void main(String[] args) {
		ReverseLinkedList rl = new ReverseLinkedList();
		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(2);
		ListNode n3=new ListNode(3);
		ListNode n4=new ListNode(4);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		
		ListNode result=rl.reverseBetween(n1, 1, 4);
		while (result!=null) {
			System.out.print(result.val+" ");
			result=result.next;
		}

	}

}
