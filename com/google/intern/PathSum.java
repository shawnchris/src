package com.google.intern;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return hasPathSumRec(root, sum);
    }
    
    private boolean hasPathSumRec(TreeNode root, int sum) {
        if (root == null) {
            if (sum == 0) return true;
            else return false;
        }
        if (sum < 0) return false;
        return hasPathSumRec(root.left, sum - root.val) || hasPathSumRec(root.right, sum - root.val);
    }
    
	public static void main(String[] args) {
		PathSum ps = new PathSum();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		n1.left = n2;
		System.out.println(ps.hasPathSum(n1, 1));
		System.out.println(ps.hasPathSum(n1, 3));
	}

}
