package j.algorithm;

import java.util.*;

class Node1 {
	public int data;
	public Node1 left;
	public Node1 right;
	public Node1(int x) {
		data=x;
	}
}
public class DepthFirstSearch {

	public static boolean search(Node1 node, int value ) {
		if( node == null ) {
			return false;
		}
		Stack<Node1> stack = new Stack<Node1>( );
		stack.push( node );
		while( ! stack.isEmpty( ) ) {
			Node1 currentNode = stack.pop( );
			if( currentNode.data == value ) {
				return true;
			}
			if( currentNode.right != null ) {
				stack.push( currentNode.right );
			}
			if( currentNode.left != null ) {
				stack.push( currentNode.left );
			}
		}
		return false;
	}

	/** Test Method */
	public static void main( String[] args ) {

	}
}
