package com.google.intern;

public class InsertionSortLinkedList {
	public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode newhead = new ListNode(0);
        newhead.next = head;
        ListNode pre1 = newhead, pre2 = null, cur1 = head.next, cur2 = null;
        
        while (cur1 != null) {
            ListNode next = cur1.next;
            pre2 = newhead; cur2 = newhead.next;
            boolean inserted = false;
            while (cur2 != cur1) {
                if (cur2.val > cur1.val) { // find the position
                    pre1.next = cur1.next;
                    pre2.next = cur1;
                    cur1.next = cur2;
                    inserted = true;
                    break;
                }
                else {
                    pre2 = cur2;
                    cur2 = cur2.next;
                }
            }
            if (!inserted) pre1 = cur1;
            cur1 = next;
        }
        
        return newhead.next;
    }
	public static void main(String[] args) {
		InsertionSortLinkedList is = new InsertionSortLinkedList();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(5);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		ListNode r =is.insertionSortList(n1);
		while (r != null) {
			System.out.print(r.val+"-> ");
			r = r.next;
		}
	}

}
