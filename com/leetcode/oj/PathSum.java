package com.leetcode.oj;

import com.leetcode.oj.TreeNode;

public class PathSum {

	public boolean hasPathSum(TreeNode root, int sum) {
        if (root==null) return false;
		if (root.val==sum)
			if (root.left==null && root.right==null)
				return true;
		if (hasPathSum(root.left, sum-root.val)) return true;
		else if (hasPathSum(root.right, sum-root.val)) return true;
		return false;
    }
	
	public static void main(String[] args) {
		PathSum ps = new PathSum();
		
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		
		n1.left=n2;
		n2.left=n3;
		n3.left=n4;
		n4.left=n5;
		
		System.out.println(ps.hasPathSum(n1, 6));

	}

}
