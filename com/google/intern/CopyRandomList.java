package com.google.intern;

import java.util.*;

class RandomListNode {
	int label;
	RandomListNode next, random;
	RandomListNode(int x) { this.label = x; }
}

public class CopyRandomList {
	HashMap<Integer, RandomListNode> map = new HashMap<Integer, RandomListNode>();

	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) return null;
		if (map.containsKey(head.label)) return map.get(head.label);

		RandomListNode newNode = new RandomListNode(head.label);
		map.put(newNode.label, newNode);

		if (head.random != null) {
			RandomListNode random = map.get(head.random.label);
			if (random == null) random = copyRandomList(head.random);
			newNode.random = random;
		}
		if (head.next != null) {
			RandomListNode next = map.get(head.next.label);
			if (next == null) next = copyRandomList(head.next);
			newNode.next = next;
		}

		return newNode;
	}
	public static void main(String[] args) {
		CopyRandomList crl = new CopyRandomList();
		RandomListNode n1 = new RandomListNode(1);
		RandomListNode n2 = new RandomListNode(2);
		RandomListNode n3 = new RandomListNode(3);
		n1.next=n2;
		n2.next=n3;
		n1.random=n3;
		n2.random=n2;
		n3.random=n1;
		RandomListNode result = crl.copyRandomList(n1);
		while (result != null) {
			int next = 0, random = 0;
			if (result.next != null) next = result.next.label;
			if (result.random != null) random = result.random.label;
			System.out.println(result.label + " " + next + " " + random);
			result = result.next;
		}
	}

}
