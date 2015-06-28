package com.leetcode.oj;

import com.leetcode.oj.TreeNode;
import com.leetcode.oj.ListNode;

public class ConvertSortedtoBST {

	public TreeNode sortedArrayToBST(int[] num) {
		if (num.length==0) return null;
		return sortedArrayToBSTRec(num, 0, num.length-1);
	}
	public TreeNode sortedArrayToBSTRec(int[] num, int low, int high) {
		if (low>high) return null;
		int mid = (low+high)/2;
		TreeNode node = new TreeNode(num[mid]);
		node.left = sortedArrayToBSTRec(num, low, mid-1);
		node.right = sortedArrayToBSTRec(num, mid+1, high);
		return node;
	}
	
	// If traverse a tree InOrder, that will the same sequence with the list.
	ListNode list = null;
	public TreeNode sortedListToBST(ListNode head) {
		if (head==null) return null;
		list = head;
		int size = 0;
		ListNode counter = head;
		while (counter!=null) {
			size++;
			counter=counter.next;
		}
		return sortedListToBSTRec(size);
	}
	public TreeNode sortedListToBSTRec(int size) {
		if (size==0) return null;
		//In-Order traverse
		TreeNode node = new TreeNode(0);
        node.left = sortedListToBSTRec(size/2);
        node.val = list.val;
        list = list.next;
        node.right = sortedListToBSTRec(size - size/2 - 1);
        return node;
	}
	public static void main(String[] args) {
		ConvertSortedtoBST cs = new ConvertSortedtoBST();
		int[] test = new int[] {2,7,9,12,24,50,60};
		

	}

}
