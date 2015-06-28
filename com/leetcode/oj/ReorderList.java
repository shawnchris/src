package com.leetcode.oj;

public class ReorderList {
	public void reorderList(ListNode head) {

		// 1. find the middle point
		if(head == null || head.next == null || head.next.next == null)return;

		ListNode a1 = head, a2 = head;

		while(a2.next!=null){
			// a1 step = 1
			a1 = a1.next;
			// a2 step = 2
			a2 = a2.next;
			if(a2.next==null)break;
			else a2 = a2.next;
		}
		// a1 now points to middle, a2 points to last elem

		// 2. reverse the second half of the list
		this.reverseList(a1);

		// 3. merge two lists
		ListNode p = head, t1 = head, t2 = head;
		while(a2!=a1){ // start from both side of the list. when a1, a2 meet, the merge finishes.
			t1 = p;
			t2 = a2;
			p = p.next;
			a2 = a2.next;

			t2.next = t1.next;
			t1.next = t2;
		}
	}

	// use recursion to reverse the right part of the list
	public ListNode reverseList(ListNode n){

		if(n.next == null){
			// mark the last node
			// this.start = n;
			return n;
		}

		reverseList(n.next).next = n;
		n.next = null;
		return n;
	}
	public static void main(String[] args) {
		ReorderList rl = new ReorderList();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		
		rl.reverseList(n1);
		while(n5!=null) {
			System.out.print(n5.val+" ");
			n5=n5.next;
		}

	}

}
