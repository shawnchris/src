package com.google.intern;

import java.util.*;

public class ReverseList {

	ListNode reverseList(ListNode n){
        if(n.next == null)
            return n;
        reverseList(n.next).next = n;
        n.next = null;
        return n;
    }

	public static void main(String[] args) {
		ArrayList<ListNode> al = new ArrayList<ListNode>();
		for (int i = 0; i < 10; i++) {
			ListNode n = new ListNode(i);
			if (i > 0)
				al.get(i-1).next = n;
			al.add(n);
		}
		ListNode p = al.get(0);
		while (p != null) {
			System.out.print(p.val + " ");
			p = p.next;
		}
		System.out.println();
		
		ReverseList rl = new ReverseList();
		rl.reverseList(al.get(0));
		p = al.get(9);
		while (p != null) {
			System.out.print(p.val + " ");
			p = p.next;
		}

	}

}
