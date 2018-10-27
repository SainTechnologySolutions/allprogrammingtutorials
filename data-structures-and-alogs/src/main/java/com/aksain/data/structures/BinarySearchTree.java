package com.aksain.data.structures;

public class BinarySearchTree<T extends Comparable<T>> {
	
	private Node root;
	
	private class Node {
		T data;
		Node left;
		Node right;
		
		private Node(T data) {
			this.data = data;
		}
	}
	
	/**
	 * Internal method for recursion
	 */
	private Node doInsert(T data, Node node) {
		if(node == null) {
			return new Node(data);
		}
		
		// If input data is less than node data, modify left else modify right
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
	
	private T minValue(Node node) {
		if(node.left != null) {
			return minValue(node.left);
		}
		
		return node.data;
	}
	
	/**
	 * Internal method for recursion
	 */
	private Node doDelete(T data, Node node) {
		if(node == null) {
			return node;
		}
		// If input data is less than node data, go left else right
		int comp_result = data.compareTo(node.data);
		if(comp_result < 0) {
			node.left = doDelete(data, node.left);
		} else if(comp_result > 0) {
			node.right = doDelete(data, node.right);
		} else {
			if(node.left == null && node.right == null) {
				//simply remove the node with no childs
				node = null;
			} else if(node.left == null) {
				// move right child node as node since no left child is present
				node = node.right;
			} else if(node.right == null) {
				// move left child node as node since no right child is present
				node = node.left;
			} else {
				// find minimum value in right subtree and assign that to current node
				node.data = minValue(node.right);
				node.right = doDelete(node.data, node.right);
			}
		}
		return node;
	}
	
	public void delete(T data) {
		root = doDelete(data, root);
	}
	
	private void doInOrder(Node node) {
		if(node == null) {
			return;
		}
		doInOrder(node.left);
		System.out.print(node.data + " ");
		doInOrder(node.right);
	}
	
	public void inOrder() {
		doInOrder(root);
		System.out.println();
	}
	
	public static void main(String[] args) {
		final BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
		binarySearchTree.insert(50);
		binarySearchTree.insert(30);
		binarySearchTree.insert(10);
		binarySearchTree.insert(20);
		binarySearchTree.insert(40);
		binarySearchTree.insert(70);
		binarySearchTree.insert(60);
		binarySearchTree.insert(80);
		binarySearchTree.insert(90);
		binarySearchTree.inOrder();
		
		binarySearchTree.delete(80);
		binarySearchTree.delete(100);
		binarySearchTree.delete(50);
		
		binarySearchTree.inOrder();
	}
}
