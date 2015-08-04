package com.google.intern;

public class CompleteTreeCount {
	int getLeftHeight(TreeNode root) {
        int height = 0;
        while (root != null) { 
            root = root.left;
            height++;
        }
        return height;
    }
    
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int left_height = getLeftHeight(root.left);
        int right_height = getLeftHeight(root.right);

        if(left_height == right_height)
       		return (1 << left_height) + countNodes(root.right);

        return (1 << right_height) + countNodes(root.left);
    }
    
	public static void main(String[] args) {
		CompleteTreeCount ct = new CompleteTreeCount();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		n1.left = n2;
		n1.right = n3;
		System.out.println(ct.countNodes(n1));
		System.out.println(2 << -1);
		System.out.println(2 << 0);
		System.out.println(2 << 1);
		System.out.println(2 >> 1);
	}

}
