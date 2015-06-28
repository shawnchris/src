package com.leetcode.oj;

import java.util.*;

class ListNode2 {
	int val;
	ListNode2 next;
	ListNode2(int x) {
		val = x;
		next = null;
	}
}

public class MergeSortedLists {

	public ListNode2 mergeKLists(List<ListNode2> lists) {
		
		if (lists==null||lists.size()==0) return null;
		
		PriorityQueue<ListNode2> pq = new PriorityQueue<ListNode2>(lists.size(),
				new Comparator<ListNode2>() {
			public int compare(ListNode2 n1, ListNode2 n2) {
				return n1.val - n2.val;
			}
		});
		
		ListNode2 head = new ListNode2(0);
        ListNode2 tail = head;

        for (ListNode2 node:lists)
            if (node!=null)
                pq.add(node);

        while (!pq.isEmpty()){
            tail.next=pq.poll();
            tail=tail.next;

            if (tail.next!=null)
                pq.add(tail.next);
        }
        
        return head.next;
	}
    
	public static void main(String[] args) {
		MergeSortedLists msl = new MergeSortedLists();
		
		List<ListNode2> test = new LinkedList<ListNode2>();
		ListNode2[][] ln = new ListNode2[3][5];
		for (int i=0; i<3; i++)
			for (int j=0; j<5; j++)
				ln[i][j] = new ListNode2(i+j);
		ln[0][0].next = ln[0][1];
		ln[0][1].next = ln[0][2];
		ln[0][2].next = ln[0][3];
		ln[0][3].next = ln[0][4];
		ln[1][0].next = ln[1][1];
		ln[1][1].next = ln[1][2];
		ln[1][2].next = ln[1][3];
		ln[1][3].next = ln[1][4];
		ln[2][0].next = ln[2][1];
		ln[2][1].next = ln[2][2];
		ln[2][2].next = ln[2][3];
		ln[2][3].next = ln[2][4];
		test.add(ln[0][0]);
		test.add(ln[1][0]);
		test.add(ln[2][0]);
		
		
		ListNode2 result = msl.mergeKLists(test);
		System.out.println();
		while(result != null) {
			System.out.print(result.val+", ");
			result = result.next;
		}

	}

}
