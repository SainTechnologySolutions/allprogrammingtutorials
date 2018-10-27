package com.aksain.data.structures;

import java.util.LinkedList;
import java.util.Queue;


public class BinaryTreeWithLevelOrderTraversal<T extends Comparable<T>> {
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
	
	private void doLevelOrderTraversal(Node root) {
		final Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			int noOfElementsAtThisLevel = queue.size();
			for(int index = 0; index < noOfElementsAtThisLevel; index++) {
				Node tmp = queue.poll();
				System.out.print(tmp.data + " ");
				if(tmp.left != null) {
					queue.add(tmp.left);
				}
				if(tmp.right != null) {
					queue.add(tmp.right);
				}
			}
			System.out.println();
		}
	}
	
	public void levelOrderTraversal() {
		doLevelOrderTraversal(root);
	}
	
	public static void main(String[] args) {
		final BinaryTreeWithLevelOrderTraversal<Integer> binaryTree = new BinaryTreeWithLevelOrderTraversal<>();
		binaryTree.insert(50);
		binaryTree.insert(30);
		binaryTree.insert(10);
		binaryTree.insert(20);
		binaryTree.insert(40);
		binaryTree.insert(70);
		binaryTree.insert(60);
		binaryTree.insert(80);
		binaryTree.insert(90);
		
		binaryTree.levelOrderTraversal();
	}

}
