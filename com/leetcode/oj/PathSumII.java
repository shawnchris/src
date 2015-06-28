package com.leetcode.oj;

import java.util.*;

class TreeNode2 {
	int val;
	TreeNode2 left;
	TreeNode2 right;
	TreeNode2(int x) { val = x; }
}

public class PathSumII {

	List<List<Integer>> lista = new ArrayList<List<Integer>>();
	List<Integer> listb = new ArrayList<Integer>();

	public List<List<Integer>> pathSum(TreeNode2 root, int sum) {
		if (root==null) return lista;
		listb.add(root.val);
		if (root.val==sum) {
			if (root.left==null && root.right==null) {
				List<Integer> listc = new ArrayList<Integer>(listb);
				lista.add(listc);
			}
		}

		pathSum(root.left, sum-root.val);
		pathSum(root.right, sum-root.val);

		listb.remove(listb.size()-1);
		return lista;
	}

	public static void main(String[] args) {
		PathSumII ps = new PathSumII();

		TreeNode2 n1 = new TreeNode2(1);
		TreeNode2 n2 = new TreeNode2(-2);
		TreeNode2 n3 = new TreeNode2(1);
		TreeNode2 n4 = new TreeNode2(-1);
		//TreeNode2 n5 = new TreeNode2(5);

		n1.left=n2;
		n2.left=n3;
		n3.left=n4;
		//n4.left=n5;

		System.out.println(ps.pathSum(n1, -1));

	}

}
