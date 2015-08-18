package com.google.intern;

import java.util.*;

public class BinaryTreePaths {
	static List<TreeNode> route = new ArrayList<TreeNode>();
    static List<String> result = new ArrayList<String>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null)
            return result;
        if (root.left == null && root.right == null) {
            String r = "";
            for (TreeNode node : route)
                r += node.val + "->";
            r += root.val;
            result.add(r);
        }
        else {
            route.add(root);
            if (root.left != null)
                binaryTreePaths(root.left);
            if (root.right != null)
                binaryTreePaths(root.right);
            route.remove(route.size()-1);
        }
        
        return result;
    }
	public static void main(String[] args) {
		BinaryTreePaths bt = new BinaryTreePaths();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		n1.left = n2;
		
		List<String> r = bt.binaryTreePaths(n1);
		for (String s : r)
			System.out.println(s);
	}

}
