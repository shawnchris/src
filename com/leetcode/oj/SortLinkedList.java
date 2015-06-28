package com.leetcode.oj;

class ListNode3 {
	int val;
	ListNode3 next;
	ListNode3 (int x) {
		val = x;
		next = null;
	}
}

public class SortLinkedList {

	

	private class MergeHelper {
		public ListNode3 newHead;
		public ListNode3 newTail;
	}
	public ListNode3 sortList(ListNode3 head) {
		if ( head == null || head.next == null) {
			return head;
		}

		ListNode3 dummyHeadOne = new ListNode3(0);
		ListNode3 dummyHeadTwo = new ListNode3(0);
		ListNode3 dummySortedHead = new ListNode3(0);
		ListNode3 dummySortedLast = dummySortedHead;
		ListNode3 unvisitedNode = head;
		MergeHelper mergeRst = new MergeHelper();

		int listLength = 0;
		int level = 0;
		while ( unvisitedNode != null && unvisitedNode.next != null ) {
			unvisitedNode = addNode ( dummyHeadOne, unvisitedNode, 1<<level);
			unvisitedNode = addNode ( dummyHeadTwo, unvisitedNode, 1<<level);
			merge ( dummyHeadOne.next, dummyHeadTwo.next, mergeRst);
			dummySortedLast.next = mergeRst.newHead;
			dummySortedLast = mergeRst.newTail;
			listLength += 2;
		}
		if (unvisitedNode != null) {
			dummySortedLast.next = unvisitedNode;
			listLength ++;
		}
		level ++;

		while ( listLength > 1 << level) {
			dummySortedLast = dummySortedHead;
			unvisitedNode = dummySortedHead.next;
			while (unvisitedNode != null) {
				unvisitedNode = addNode ( dummyHeadOne, unvisitedNode, 1<<level);
				unvisitedNode = addNode ( dummyHeadTwo, unvisitedNode, 1<<level);
				merge ( dummyHeadOne.next, dummyHeadTwo.next, mergeRst);
				dummySortedLast.next = mergeRst.newHead;
				dummySortedLast = mergeRst.newTail;
			}
			level ++;
		}

		return dummySortedHead.next;
	}

	/* merge listOne and listTwo. 
	Save the sorted list head into rst.newHead
	Save the last node of the sorted list into rst.newTail
	*/
	private void merge (ListNode3 listOne, ListNode3 listTwo, MergeHelper rst) {
		ListNode3 dummyHead = new ListNode3 (0);
		ListNode3 lastNode = dummyHead;
		while (listOne != null && listTwo != null) {
			if ( listOne.val < listTwo.val ) {
				lastNode.next = listOne;
				listOne = listOne.next;
			} else {
				lastNode.next = listTwo;
				listTwo = listTwo.next;
			}
			lastNode = lastNode.next;
		}

		while (listOne != null) {
			lastNode.next = listOne;
			listOne = listOne.next;
			lastNode = lastNode.next;
		}
		while ( listTwo != null ) {
			lastNode.next = listTwo;
			listTwo = listTwo.next;
			lastNode = lastNode.next;
		}
		rst.newHead = dummyHead.next;
		rst.newTail = lastNode;
	}

	/*
 	add at max #"count" nodes into "head" from "source"
 	return the new position of source after adding.
	*/
	private ListNode3 addNode ( ListNode3 head, ListNode3 source, int count ) {
		while (count > 0 && source != null) {
			head.next = source;
			head = head.next;
			source = source.next;
			count --;
		}
		head.next = null;
		return source;
	}

	public static void main(String[] args) {
		SortLinkedList sll = new SortLinkedList();
		ListNode3[] test = new ListNode3[10];
		for (int i=8; i>=0; i--) {
			test[i]=new ListNode3(10-i);
			test[i].next=test[i+1];
		}
		test[9]=new ListNode3(1);
		ListNode3 result = sll.sortList(test[0]);
		
		while(result!=null) {
			System.out.print(result.val + " ");
			result=result.next;
		}
	}
}

/*
At each level, each group only contains at maximum 2^level elements. Merge-sort theses groups pair by pair. Then level ++. Stop until 2^level > n. Assume the original input is :

	  level 0        5, 3, 6, 1, 4, 2, 7
	After level 0, we got the length of the list and the list become:

	  level 1        3, 5,   1, 6,    2, 4,    7
	Now each group contains 2 elements. After level 1, the list become:

	  level 2        1, 3, 5, 6,    2, 4, 7
	Now each group contains 2^2 = 4 elements. After level 2, the list become:

	  level 3        1, 2, 3, 4, 5, 6, 7
	Now, 2^3 > 7, stop.

	Time complexity: In each level, each node is visited by at maximum twice. And there are log(n) level. Thus the time complexity is O(2n* log n ) => O( n* log n )
	Space complexity: There are no recursion calls in this solution. Thus the maximum number of function calls is constant. The number of dummy nodes is constant. Thus the auxiliary space complexity is O(1).
 */