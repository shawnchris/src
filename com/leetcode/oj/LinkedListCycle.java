package com.leetcode.oj;

import java.util.ArrayList;

public class LinkedListCycle {



	public static boolean hasCycle(ListNode head) {
		boolean result = false;
		ArrayList<ListNode> al = new ArrayList<ListNode>();
		
		if (head==null) return false;
		
		while (head.next != null) {
			if (al.contains(head.next)) {
				result = true;
				break;
			}
			al.add(head);
			head = head.next;

		}
		
		return result;
	}
	
	public static boolean hasCycle2(ListNode head) {

		if ((head == null) || (head.next == null)) 
			return false;
		ListNode slow = head;
		ListNode fast = head;

		while ((fast.next != null) && (fast.next.next != null)) {
			//System.out.println("fast:"+fast.val+" slow:"+slow.val);
			if ((fast.next == slow) || (fast.next.next == slow)) 
				return true;
			fast = fast.next.next;
			slow = slow.next;

		}
		return false;
	}
	public static void main(String[] arg) {
		ListNode[] ln = new ListNode[100];
		ln[99] = new ListNode(99);
		for (int i=98; i>=0; i--) {
			ln[i] = new ListNode(i);
			ln[i].next = ln[i+1];
		}
		ln[99].next = ln[7];
		System.out.println(hasCycle(ln[0]));
		System.out.println(hasCycle2(ln[0]));
	}
}
/*
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}
*/