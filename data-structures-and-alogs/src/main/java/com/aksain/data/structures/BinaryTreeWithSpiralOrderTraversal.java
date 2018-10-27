package com.aksain.data.structures;

import java.util.Stack;

public class BinaryTreeWithSpiralOrderTraversal<T extends Comparable<T>> {
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
		if (node == null) {
			return new Node(data);
		}
		int result = data.compareTo(node.data);
		if (result < 0) {
			node.left = doInsert(data, node.left);
		} else if (result > 0) {
			node.right = doInsert(data, node.right);
		}

		return node;
	}

	public void insert(T data) {
		root = doInsert(data, root);
	}

	private void doSpiralOrderTraversal(Node root) {
		final Stack<Node> leftToRight = new Stack<>();
		leftToRight.add(root);

		final Stack<Node> rightToLeftQueue = new Stack<>();

		while (!leftToRight.isEmpty() || !rightToLeftQueue.isEmpty()) {
			while (!leftToRight.isEmpty()) {
				Node tmp = leftToRight.pop();
				System.out.print(tmp.data + " ");
				if (tmp.left != null) {
					rightToLeftQueue.push(tmp.left);
				}
				if (tmp.right != null) {
					rightToLeftQueue.push(tmp.right);
				}
			}
			System.out.println();

			while (!rightToLeftQueue.isEmpty()) {
				Node tmp = rightToLeftQueue.pop();
				System.out.print(tmp.data + " ");
				if (tmp.right != null) {
					leftToRight.push(tmp.right);
				}
				if (tmp.left != null) {
					leftToRight.push(tmp.left);
				}
			}
			System.out.println();
		}

	}

	public void spiralOrderTraversal() {
		doSpiralOrderTraversal(root);
	}

	public static void main(String[] args) {
		final BinaryTreeWithSpiralOrderTraversal<Integer> binaryTree = new BinaryTreeWithSpiralOrderTraversal<>();
		binaryTree.insert(50);
		binaryTree.insert(30);
		binaryTree.insert(10);
		binaryTree.insert(20);
		binaryTree.insert(40);
		binaryTree.insert(70);
		binaryTree.insert(60);
		binaryTree.insert(80);
		binaryTree.insert(90);

		binaryTree.spiralOrderTraversal();
	}

}
