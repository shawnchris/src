package com.google.intern;

public class kthSmallestElementBST {
	int sk = 0;
	public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        int left = kthSmallest(root.left, k);
        if (left != -1) return left;
        else {
            sk++;
            if (sk == k) return root.val;
            else
                return kthSmallest(root.right, k);
        }
    }
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(1);
		node1.left = node2;
		
		kthSmallestElementBST kse = new kthSmallestElementBST();
		System.out.println(kse.kthSmallest(node1, 2));
	}

}
