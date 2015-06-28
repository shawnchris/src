package com.leetcode.oj;

import com.leetcode.oj.TreeNode;
import java.util.*;

public class SumRootToLeaf {

	public int sumNumbersBFS(TreeNode root) {
		Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
		Queue<Integer> queue2 = new LinkedList<Integer>();
		int result=0;

		if (root==null) return 0;
		
		queue1.add(root);
		queue2.add(root.val);
		//sum=root.val;
		while(!queue1.isEmpty()){
	        TreeNode node = queue1.remove();
	        int csum = queue2.remove();
	        //sum = sum*10 + node.val;
	        if (node.left==null && node.right==null){ // leaf
	        	result = result + csum;
	        }
	        if(node.left != null) {
	        	queue1.add(node.left);
	        	queue2.add(csum*10+node.left.val);
	        }
	        if(node.right != null) {
	        	queue1.add(node.right);
	        	queue2.add(csum*10+node.right.val);
	        }
	    }
		return result;
	}
	
	public int sumNumbersDFS(TreeNode root) {
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<Integer> stack2 = new Stack<Integer>();
		int result=0;

		if (root==null) return 0;
		
		stack1.push(root);
		stack2.push(root.val);
		while(!stack1.isEmpty()){
	        TreeNode node = stack1.pop();
	        int csum = stack2.pop();
	        if (node.left==null && node.right==null){ // leaf
	        	result = result + csum;
	        }
	        if(node.left != null) {
	        	stack1.push(node.right);
	        	stack2.push(csum*10+node.right.val);
	        }
	        if(node.right != null) {
	        	stack1.push(node.right);
	        	stack2.push(csum*10+node.left.val);
	        }
	    }
		return result;
	}
	
	public static void main(String[] args) {
		SumRootToLeaf srl = new SumRootToLeaf();
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		node1.left=node2;
		node1.right=node3;
		
		System.out.println(srl.sumNumbersBFS(node1));
		System.out.println(srl.sumNumbersBFS(node1));

	}

}
