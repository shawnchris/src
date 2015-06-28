package j.algorithm;

/**
 * Represents a node in the Binary Search Tree.
 */
class Node2<T> {
	//The value present in the node.
	public int value;

	//The reference to the left subtree.
	public Node2 left;

	//The reference to the right subtree.
	public Node2 right;

	public Node2(int value) {
		this.value = value;
	}

}

/**
 * Represents the Binary Search Tree.
 */
class BinarySearchTree {

	//Refrence for the root of the tree.
	public Node2 root;

	public BinarySearchTree insert(int value) {
		Node2 node = new Node2<>(value);

		if (root == null) {
			root = node;
			return this;
		}

		insertRec(root, node);
		return this;
	}

	private void insertRec(Node2 latestRoot, Node2 node) {

		if (latestRoot.value > node.value) {

			if (latestRoot.left == null) {
				latestRoot.left = node;
				return;
			} else {
				insertRec(latestRoot.left, node);
			}
		} else {
			if (latestRoot.right == null) {
				latestRoot.right = node;
				return;
			} else {
				insertRec(latestRoot.right, node);
			}
		}
	}

	/**
	 * Returns the minimum value in the Binary Search Tree.
	 */
	public int findMinimum() {
		if (root == null) {
			return 0;
		}
		Node2 currNode = root;
		while (currNode.left != null) {
			currNode = currNode.left;
		}
		return currNode.value;
	}

	/**
	 * Returns the maximum value in the Binary Search Tree
	 */
	public int findMaximum() {
		if (root == null) {
			return 0;
		}

		Node2 currNode = root;
		while (currNode.right != null) {
			currNode = currNode.right;
		}
		return currNode.value;
	}

	/**
	 * Printing the contents of the tree in an inorder way.
	 */
	public void printInorder() {
		printInOrderRec(root);
		System.out.println("");
	}

	/**
	 * Helper method to recursively print the contents in an inorder way
	 */
	private void printInOrderRec(Node2 currRoot) {
		if (currRoot == null) {
			return;
		}
		printInOrderRec(currRoot.left);
		System.out.print(currRoot.value + ", ");
		printInOrderRec(currRoot.right);
	}

	/**
	 * Printing the contents of the tree in a Preorder way.
	 */
	public void printPreorder() {
		printPreOrderRec(root);
		System.out.println("");
	}

	/**
	 * Helper method to recursively print the contents in a Preorder way
	 */
	private void printPreOrderRec(Node2 currRoot) {
		if (currRoot == null) {
			return;
		}
		System.out.print(currRoot.value + ", ");
		printPreOrderRec(currRoot.left);
		printPreOrderRec(currRoot.right);
	}

	/**
	 * Printing the contents of the tree in a Postorder way.
	 */
	public void printPostorder() {
		printPostOrderRec(root);
		System.out.println("");
	}

	/**
	 * Helper method to recursively print the contents in a Postorder way
	 */
	private void printPostOrderRec(Node2 currRoot) {
		if (currRoot == null) {
			return;
		}
		printPostOrderRec(currRoot.left);
		printPostOrderRec(currRoot.right);
		System.out.print(currRoot.value + ", ");

	}
}

public class BinarySearchTreeDemo {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst .insert(40)
		.insert(25)
		.insert(78)
		.insert(10)
		.insert(3)
		.insert(17)
		.insert(32)
		.insert(30)
		.insert(38)
		.insert(78)
		.insert(50)
		.insert(93);
		System.out.println("Inorder traversal");
		bst.printInorder();

		System.out.println("Preorder Traversal");
		bst.printPreorder();

		System.out.println("Postorder Traversal");
		bst.printPostorder();

		System.out.println("The minimum value in the BST: " + bst.findMinimum());
		System.out.println("The maximum value in the BST: " + bst.findMaximum());

	}
}

