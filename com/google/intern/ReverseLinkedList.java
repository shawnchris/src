package com.google.intern;

public class ReverseLinkedList {
	
	ListNode newhead = null;
	ListNode reverseRec(ListNode n) {
		reverseRecAux(n);
		return newhead;
	}
	ListNode reverseRecAux(ListNode n) {
		if (n.next == null) {
			newhead = n;
			return n;
		}
		reverseRecAux(n.next).next = n;
		n.next = null;
		return n;
	}

	ListNode reverseIter(ListNode n) {
		ListNode prev = null, next = null;
		while (n != null) {
			next = n.next;
			n.next = prev;
			prev = n;
			n = next;
		}
		return prev;
	}
	
	public static void main(String[] args) {
		ReverseLinkedList rl = new ReverseLinkedList();
		ListNode[] ln = new ListNode[6];
		for (int i=0; i<6; i++)
			ln[i] = new ListNode(i);
		for (int i=0; i<5; i++)
			ln[i].next = ln[i+1];
		printList(ln[0]);
		ListNode result = rl.reverseIter(ln[0]);
		printList(result);
		result = rl.reverseRec(result);
		printList(result);
	}
	
	static void printList(ListNode n) {
		while (n != null) {
			System.out.print(n.val + "->");
			n = n.next;
		}
		System.out.println("NULL");
	}
}
