package com.leetcode.oj;

import java.util.*;

class TreeNode3 {
	int val;
	TreeNode3 left;
	TreeNode3 right;
	TreeNode3 (int x) { val = x; }
}

public class MinDepthBinTree {
	
	public int minDepth(TreeNode3 root) {
		Queue<TreeNode3> queue1 = new LinkedList<TreeNode3>();
		Queue<Integer> queue2 = new LinkedList<Integer>();

		int depth=0;
		if (root==null) return depth;
		
		queue1.add(root);
		depth=1;
		queue2.add(depth);
		while(!queue1.isEmpty()){
	        TreeNode3 node = queue1.remove();
	        depth = queue2.remove();
	        if (node.left==null && node.right==null)
	        	return depth;
	        if(node.left != null) {
	        	queue1.add(node.left);
	        	queue2.add(depth+1);
	        }
	        if(node.right != null) {
	        	queue1.add(node.right);
	        	queue2.add(depth+1);
	        }
	    }
		return depth;
	}
	
	public static void main(String[] args) {
		MinDepthBinTree mdt = new MinDepthBinTree();
		TreeNode3 n1 = new TreeNode3(1);
		TreeNode3 n2 = new TreeNode3(-2);
		TreeNode3 n3 = new TreeNode3(1);
		TreeNode3 n4 = new TreeNode3(-1);
		TreeNode3 n5 = new TreeNode3(5);

		n1.left=n2;
		n2.left=n3;
		n3.left=n4;
		n4.left=n5;
		System.out.println(mdt.minDepth(n1));
		Character c = ' ';
	}
	

}
