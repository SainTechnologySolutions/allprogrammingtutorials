package com.aksain.data.structures;

public class BinaryTreeWithPostOrderTraversal<T extends Comparable<T>> {
	private Node root;
	
	private class Node {
		T data;
		Node left;
		Node right;
		
		private Node(T data) {
			this.data = data;
		}
	}
	
	private Node doInsert(T data, Node node) {
		if(node == null) {
			return new Node(data);
		}
		int result = data.compareTo(node.data);
		if(result < 0) {
			node.left = doInsert(data, node.left);
		} else if(result > 0) {
			node.right = doInsert(data, node.right);
		}
		
		return node;
	}
	
	public void insert(T data) {		
		root = doInsert(data, root);
	}
	
	private void doPostOrder(Node node) {
		if(node == null) {
			return;
		}
		doPostOrder(node.left);
		doPostOrder(node.right);
		System.out.print(node.data + " ");
	}
	
	public void postOrder() {
		doPostOrder(root);
		System.out.println();
	}
	
	public static void main(String[] args) {
		final BinaryTreeWithPostOrderTraversal<Integer> binaryTree = new BinaryTreeWithPostOrderTraversal<>();
		binaryTree.insert(50);
		binaryTree.insert(30);
		binaryTree.insert(10);
		binaryTree.insert(20);
		binaryTree.insert(40);
		binaryTree.insert(70);
		binaryTree.insert(60);
		binaryTree.insert(80);
		binaryTree.insert(90);
		
		binaryTree.postOrder();
	}
}
