package com.leetcode.oj;

public class ConstructBinaryTree {

	/* The the basic idea is to take the last element in postorder array as the root, 
	 * find the position of the root in the inorder array; then locate the range for 
	 * left sub-tree and right sub-tree and do recursion.
	*/
	public TreeNode buildTreeIP(int[] inorder, int[] postorder) {
        pInorder = inorder.length - 1;
        pPostorder = postorder.length - 1;

        return buildTreeIPRec(inorder, postorder, null);
    }
    int pInorder;   // index of inorder array
    int pPostorder; // index of postorder array
    private TreeNode buildTreeIPRec(int[] inorder, int[] postorder, TreeNode end) {
        if (pPostorder < 0) return null;

        // create root node
        TreeNode n = new TreeNode(postorder[pPostorder]);
        pPostorder--;

        // if right node exist, create right subtree
        if (inorder[pInorder] != n.val)
            n.right = buildTreeIPRec(inorder, postorder, n);
        pInorder--;

        // if left node exist, create left subtree
        if ((end == null) || (inorder[pInorder] != end.val))
            n.left = buildTreeIPRec(inorder, postorder, end);

        return n;
    }
    /* The basic idea is here: Say we have 2 arrays, PRE and IN. 
     * Preorder traversing implies that PRE[0] is the root node. 
     * Then we can find this PRE[0] in IN, say it's IN[5]. 
     * Now we know that IN[5] is root, so we know that IN[0] - IN[4] is on the left side, 
     * IN[6] to the end is on the right side. 
     * Recursively doing this on subarrays, we can build a tree out of it.
     */
    public TreeNode buildTreePI(int[] preorder, int[] inorder) {
        return buildTreePIRec(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode buildTreePIRec(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = buildTreePIRec(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = buildTreePIRec(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
	public static void main(String[] args) {
		//Inorder traversal result
		int[] inorder = new int[] {3, 10, 17, 25, 30, 32, 38, 40, 50, 78, 78, 93, };
		//Preorder Traversal result
		int[] preorder = new int[] {40, 25, 10, 3, 17, 32, 30, 38, 78, 50, 78, 93, };
		//Postorder Traversal result
		int[] postorder = new int[] {3, 17, 10, 30, 38, 32, 25, 50, 93, 78, 78, 40, };
		
		int[] inorder1 = new int[] {5,8,10,12,14,16,18};
		int[] postorder1 = new int[] {5,10,8,14,18,16,12};
		
		ConstructBinaryTree cbt = new ConstructBinaryTree();
		cbt.buildTreeIP(inorder, postorder);
		

	}

}
